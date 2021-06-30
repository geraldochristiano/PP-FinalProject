package spril_converter;

import grammar.DBaseVisitor;
import grammar.DParser.*;
import org.antlr.v4.runtime.tree.ParseTree;
import type_checking.Type;

import java.util.ArrayList;
import java.util.HashSet;

public class SprilConverter extends DBaseVisitor<String> {

    public static final SprilConverter INSTANCE = new SprilConverter();

    private static final int SHARED_MEM_SIZE = 8;

    private ArrayList<String> errors;
    private ArrayList<ArrayList<Variable>> variablesOffsets;
    private Result result;
    private boolean[] threadActive;
    private ArrayList<MemoryContent> sharedMemory;

    // Quicker access to check if a variable is a shared variable than searching it in 'result'
    private HashSet<String> sharedVariablesNames;

    @Override
    public String visitProgram (ProgramContext ctx){
        threadActive[0] = true; // Thread 0 active
        variablesOffsets.add(new ArrayList<>()); // global level scope
        StringBuilder program = new StringBuilder();
        program.append("import Sprockell\n\n")
                .append("prog::[Instruction]\n")
                .append("prog = [");
        if (threadActive.length > 1){
            program.append("Compute Equal reg0 regSprID regA,\n")
                    .append("\tBranch regA (Rel 7),\n")
                    .append("\tReadInstr (IndAddr regSprID),\n")
                    .append("\tReceive regA,\n")
                    .append("\tCompute Equal regA reg0 regB,\n")
                    .append("\tBranch regB (Rel (-3)),\n")
                    .append("\tWriteInstr reg0 (IndAddr regSprID),\n")
                    .append("\tJump (Ind regA),\n");
        }
        for (int i = 0; i < ctx.stat().size(); i++){
            String children = visit(ctx.stat(i));
            program.append(children);
        }
        program.append("\tEndProg]\n\n")
                .append("main = run [prog")
                .append(",prog".repeat(threadActive.length - 1)).append("]")
                .append("main_1 = runWithDebugger (debuggerSimplePrintAndWait myShow) [prog")
                .append(",prog".repeat(threadActive.length - 1)).append("]");
        return program.toString();
    }

    @Override
    public String visitDeclareStat(DeclareStatContext ctx){
        if (ctx.SHARED() == null) { // local variable(s) declaration
            int variableSize = 1;
            Type type = null;
            switch (ctx.dataType().getText()){ // get type of variable(s)
                case "int" -> type = Type.INTEGER;
                case "bool" -> type = Type.BOOLEAN;
                case "char" -> type = Type.CHARACTER;
            }
            int nextOffset = getNextStartOffset();
            for (int i = 0; i < ctx.ID().size(); i++){
                variablesOffsets.get(variablesOffsets.size() - 1).
                        add(new Variable(ctx.ID(i).getText(),nextOffset,(nextOffset + variableSize - 1), type));
                nextOffset += variableSize;
            }
        }
        return "";
    }

    @Override
    public String visitAssignStat(AssignStatContext ctx){
        StringBuilder stat = new StringBuilder();
        if (ctx.dataType() !=  null) { // variable(s) are declared and assigned
            if (ctx.SHARED() != null){

            }
        } else { // variable(s) are only assigned
            for (int i = 0; i < ctx.ID().size(); i++){
                String id = ctx.ID(i).getText();
                String expr = visit(ctx.expr(i));
                stat.append(expr);
                if (sharedVariablesNames.contains(id)){ // shared variable
                    TwoTuple<SharedVariable, Integer> sharedVar = getSharedVariableAndIndex(id);
                    int sharedVarIdx = sharedVar.snd();
                    stat.append("\tPop regA,\n")
                            .append("\tWriteInstr regA (DirAddr ").append(sharedVarIdx).append("),\n");
                } else {
                    int localMemoryOffset = getLastDeclaredVariableOffset(id);
                    stat.append("\tPop regA,\n")
                            .append("\t");
                }
            }
        }
        return stat.toString();
    }

    public TwoTuple<SharedVariable,Integer> getSharedVariableAndIndex(String id){
        int shMemIndex = 0;
        for (MemoryContent memoryContent : sharedMemory) {
            if (memoryContent instanceof SharedVariable sharedVar) {
                if (sharedVar.getName().equals(id)) {
                    return new TwoTuple<>(sharedVar, shMemIndex);
                } else {
                    shMemIndex += sharedVar.getLengthInMemory();
                }
            } else {
                shMemIndex++;
            }
        }
        return null;
    }


    private int getNextStartOffset(){
        ArrayList<Variable> currentScope = variablesOffsets.get(variablesOffsets.size() - 1);
        if (currentScope.size() == 0) return 0;
        else {
            Variable lastVariable = currentScope.get(currentScope.size() - 1);
            return lastVariable.getEndOffset() + 1;
        }
    }

    /**
     * Get the offset of the latest variable declared with the given name relative to the current scope offset.
     * @param id identifier of the variable
     * @return the relative offset from the current scope offset
     */
    private int getLastDeclaredVariableOffset(String id){
        int offset = 0;
        for (int i = variablesOffsets.size() - 1; i >= 0 ;i--){
            ArrayList<Variable> currScopeVars = variablesOffsets.get(i);
            int relativeOffset = 0;
            for (Variable var : currScopeVars){
                if (var.getName().equals(id)){
                    return offset + relativeOffset;
                } else {
                    relativeOffset += (var.getEndOffset() - var.getStartOffset() + 1);
                }
            }
            if (i > 0){
                offset -= getScopeTotalSize(variablesOffsets.get(i - 1));
            }
        }
        return -1;
    }

    /**
     * Get the total size of all variables on the given scope.
     * @param scope scope to be checked
     * @return the total size of all variables on the scope
     */
    private int getScopeTotalSize(ArrayList<Variable> scope){
        int totalOffsets = 0;
        for (Variable var : scope){
            totalOffsets += var.getEndOffset() - var.getStartOffset() + 1;
        }
        return totalOffsets;
    }

    private String getAnAvailableThread(){
        for (int i = 0; i < threadActive.length; i++){
            if (!threadActive[i]){
                return String.valueOf(i);
            }
        }
        return null;
    }

    private boolean initializeConverter(Result res) {
        result = res;
        errors = new ArrayList<>();

        // get required number of threads
        int numberOfThreads = result.getThreadsNeeded();

        // get all shared variables total size
        int sharedVarSize = result.getSharedVariables().size();

        // check if a lock for critical section is needed
        int criticalSectionLock = result.getCriticalSectionExist() ? 1 : 0;

        // Check if shared memory is sufficient for storing all threads start addresses, shared variables, and critical
        // section lock.
        if ((numberOfThreads + sharedVarSize + criticalSectionLock) > SHARED_MEM_SIZE){
            errors.add("Shared memory size insufficient. Required memory size: "
                    + (numberOfThreads + sharedVarSize + criticalSectionLock));
            return false;
        }

        variablesOffsets = new ArrayList<>();
        threadActive = new boolean[numberOfThreads];
        sharedMemory = new ArrayList<>();
        sharedVariablesNames = new HashSet<>();
        int i = 0;

        // allocate memory for threads start addresses
        for (;i < numberOfThreads;i++) sharedMemory.add(new ThreadStartAddress(i));

        // allocate memory for shared variables
        for (TwoTuple<String, Type> sharedVar : result.getSharedVariables()){
            sharedMemory.add(new SharedVariable(sharedVar.fst(), sharedVar.snd(), 1));
            if (!sharedVariablesNames.add(sharedVar.fst())) errors.add("Duplicate shared variable name");
            i++;
        }
        if (criticalSectionLock == 1)
            sharedMemory.add(new Lock("critical section lock")); // allocate memory for lock if required
        return true;
    }

    public String convertToSpril(ParseTree tree, Result result){
        if (result == null) return null;
        if (!initializeConverter(result)){
            errors.forEach(System.out::println);
            return null;
        }
        return visit(tree);
    }

}
