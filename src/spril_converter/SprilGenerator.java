package spril_converter;

import grammar.DBaseVisitor;
import grammar.DParser.*;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import type_checking.Type;
import type_checking.TypeAndDeclarationChecker;

import java.util.ArrayList;
import java.util.HashSet;

public class SprilGenerator extends DBaseVisitor<String> {

    public static final SprilGenerator INSTANCE = new SprilGenerator();

    /** HARDCODED VARIABLE!*/
    public static int SHARED_MEM_SIZE = 200;
    public static int CHANNEL_DELAY = 4;

    private ArrayList<String> errors;
    private ArrayList<ArrayList<Variable>> variablesOffsets;
    private Result result;
    private boolean[] threadActive;
    private ArrayList<MemoryContent> sharedMemory;

    // A set containing the name of shared variables
    // Quicker access to check if a variable is a shared variable rather than searching it in 'result'
    private HashSet<String> sharedVariablesNames;

    // A list containing the indexes of the locks in shared memory
    // Retrieve lock indexes by removing from head of list
    // All critical sections have different locks, so as to allow multiple critical sections in sequence
    private ArrayList<Integer> locksIndexes;


    @Override
    public String visitProgram (ProgramContext ctx){
        threadActive[0] = true; // Thread 0 active
        variablesOffsets.add(new ArrayList<>()); // global level scope
        StringBuilder program = new StringBuilder();
        program.append("import Sprockell\nimport Data.Char\n\n")
                .append("prog::[Instruction]\n")
                .append("prog = [");
        if (threadActive.length > 1){
            program.append("Compute Equal reg0 regSprID regA,\n")
                    .append("\tBranch regA (Rel 6),\n")
                    .append("\tReadInstr (IndAddr regSprID),\n")
                    .append("\tReceive regA,\n")
                    .append("\tCompute Equal regA reg0 regB,\n")
                    .append("\tBranch regB (Rel (-3)),\n")
                    .append("\tJump (Ind regA),\n");
        }else program.append("\n");

        for (int i = 0; i < ctx.stat().size(); i++){
            String children = visit(ctx.stat(i));
            program.append(children);
        }

        if (threadActive.length > 1){
            program.append("\tLoad (ImmValue (").append(threadActive.length).append(")) regA,\n")
                    .append("\tCompute Add regPC regA regA,\n");
            for (int i = 1; i < threadActive.length;i ++){
                program.append("\tWriteInstr regA (DirAddr (").append(i).append(")),\n");
            }
        }

        program.append("\tEndProg]\n\n")
                .append("main = run [prog")
                .append(",prog".repeat(threadActive.length - 1)).append("]\n")
                .append("main_1 = runWithDebugger (debuggerSimplePrintAndWait myShow) [prog")
                .append(",prog".repeat(threadActive.length - 1)).append("]\n");
        variablesOffsets.remove(variablesOffsets.size() - 1);
        return program.toString();
    }

    @Override
    public String visitDeclareStat(DeclareStatContext ctx){
        if (ctx.SHARED() == null) { // local variable(s) declaration
            Type type = null;
            switch (ctx.dataType().getText()){ // get type of variable(s)
                case "int" -> type = Type.INTEGER;
                case "bool" -> type = Type.BOOLEAN;
                case "char" -> type = Type.CHARACTER;
            }
            addVariable(ctx.ID().getText(), type);
        }
        return "";
    }

    @Override
    public String visitAssignStat(AssignStatContext ctx){
        StringBuilder stat = new StringBuilder();
        final String id = ctx.ID().getText();
        stat.append(visit(ctx.expr()));
        if (ctx.dataType() !=  null) { // variable(s) are declared and assigned
            if (ctx.SHARED() != null){ // shared variable
                // shared variables doesn't have to be declared, since they are already reserved space in shared memory

                // assign value
                TwoTuple<SharedVariable, Integer> sharedVar = getSharedVariableAndIndex(id);
                int sharedVarIdx = sharedVar.snd();
                stat.append("\tPop regA,\n")
                        .append("\tWriteInstr regA (DirAddr (").append(sharedVarIdx).append(")),\n");
            } else { // local variable
                // declare a variable and reserve space for it
                Type type = null;
                switch (ctx.dataType().getText()){ // get type of variable(s)
                    case "int" -> type = Type.INTEGER;
                    case "bool" -> type = Type.BOOLEAN;
                    case "char" -> type = Type.CHARACTER;
                }
                addVariable(id, type);

                // assign value
                int relMemoryOffset = getLastDeclaredVariableOffset(id);
                stat.append("\tPop regA,\n")
                        .append("\tLoad (ImmValue (").append(relMemoryOffset).append(")) regE,\n")
                        .append("\tCompute Add regE regF regE,\n")
                        .append("\tStore regA (IndAddr regE),\n");
            }

        } else { // variable(s) are only assigned
            if (sharedVariablesNames.contains(id)){ // shared variable
                TwoTuple<SharedVariable, Integer> sharedVar = getSharedVariableAndIndex(id);
                int sharedVarIdx = sharedVar.snd();
                stat.append("\tPop regA,\n")
                        .append("\tWriteInstr regA (DirAddr (").append(sharedVarIdx).append(")),\n");

            } else { // local variable
                int relMemoryOffset = getLastDeclaredVariableOffset(id);
                stat.append("\tPop regA,\n")
                        .append("\tLoad (ImmValue (").append(relMemoryOffset).append(")) regE,\n")
                        .append("\tCompute Add regE regF regE,\n")
                        .append("\tStore regA (IndAddr regE),\n");
            }
        }
        return stat.toString();
    }

    @Override
    public String visitIncrStat(IncrStatContext ctx){
        StringBuilder stat = new StringBuilder();
        final String id = ctx.ID().getText();
        if (sharedVariablesNames.contains(id)){
            TwoTuple<SharedVariable, Integer> sharedVar = getSharedVariableAndIndex(id);
            int sharedVarIdx = sharedVar.snd();
            stat.append("\tReadInstr (DirAddr (").append(sharedVarIdx).append("),\n)")
                    .append("\tReceive regA,\n")
                    .append("\tCompute Incr regA regA regA,\n")
                    .append("\tWriteInstr regA (DirAddr (").append(sharedVarIdx).append(")),\n");
        } else {
            int relMemoryOffset = getLastDeclaredVariableOffset(id);
            stat.append("\tLoad (ImmValue (").append(relMemoryOffset).append(")) regE,\n")
                    .append("\tCompute Add regE regF regE,\n")
                    .append("\tLoad (IndAddr regE) regA,\n")
                    .append("\tCompute Incr regA regA regA,\n")
                    .append("\tStore regA (IndAddr regE),\n");
        }
        return stat.toString();
    }

    @Override
    public String visitDecrStat(DecrStatContext ctx){
        StringBuilder stat = new StringBuilder();
        final String id = ctx.ID().getText();
        if (sharedVariablesNames.contains(id)){
            TwoTuple<SharedVariable, Integer> sharedVar = getSharedVariableAndIndex(id);
            int sharedVarIdx = sharedVar.snd();
            stat.append("\tReadInstr (DirAddr (").append(sharedVarIdx).append("),\n)")
                    .append("\tReceive regA,\n")
                    .append("\tCompute Decr regA regA regA,\n")
                    .append("\tWriteInstr regA (DirAddr (").append(sharedVarIdx).append(")),\n");
        } else {
            int relMemoryOffset = getLastDeclaredVariableOffset(id);
            stat.append("\tLoad (ImmValue (").append(relMemoryOffset).append(")) regE,\n")
                    .append("\tCompute Add regE regF regE,\n")
                    .append("\tLoad (IndAddr regE) regA,\n")
                    .append("\tCompute Decr regA regA regA,\n")
                    .append("\tStore regA (IndAddr regE),\n");
        }
        return stat.toString();
    }

    @Override
    public String visitWhilstStat(WhilstStatContext ctx){
        StringBuilder stat = new StringBuilder();
        stat.append("\t--whilst ").append(ctx.expr().getText()).append("\n");     // HASKELL COMMENT
        stat.append(openScope());

        addVariable("__continue", Type.WILDCARD);
        addVariable("__break", Type.WILDCARD);
        String conditionExpr = visit(ctx.expr());
        int conditionLength = countProgramLength(conditionExpr);
        String body = visit(ctx.stat());
        body += "\tLoad (IndAddr regF) regE,\n" +
                "\tJump (Ind regE),\n";
        int bodyStatLen = countProgramLength(body);

        // insert the address of where the program counter will go when executing 'continue' or finishing
        // body to memory in variable '__continue'
        stat.append("\t -- inserting continue\n");              // HASKELL COMMENT
        stat.append("\tLoad (ImmValue (").append(6).append(")) regC,\n")
                .append("\tCompute Add regPC regC regC,\n")
                .append("\tStore regC (IndAddr regF),\n");
        // insert the address of where the program counter will go when executing 'break' to memory in variable
        // '__break'
        stat.append("\t -- inserting break\n");                 // HASKELL COMMENT
        stat.append("\tLoad (ImmValue (").append(2 + conditionLength + 3).append(")) regC,\n")
                .append("\tCompute Add regPC regC regC,\n")
                .append("\tCompute Incr regF regF regE,\n")
                .append("\tStore regC (IndAddr regE),\n");
        // insert the condition and program jump
        stat.append("\t-- whilst condition\n");                 // HASKELL COMMENT
        stat.append(conditionExpr)
                .append("\tPop regA,\n")
                .append("\tBranch regA (Rel 2),\n")
                .append("\tJump (Rel (").append(bodyStatLen + 1).append(")),\n");
        // insert the whilst body
        stat.append("\t -- body\n");
        stat.append(body);
        stat.append("\t-- body end\n");

        stat.append(closeScope());
        stat.append("\t --whilst end\n");                       // HASKELL COMMENT
        return stat.toString();
    }

    @Override
    public String visitWheneverStat(WheneverStatContext ctx){
        StringBuilder stat = new StringBuilder();
        stat.append("\t--whenever ").append(ctx.expr().getText()).append("\n"); // HASKELL COMMENT
        stat.append(visit(ctx.expr()));
        stat.append("\tPop regA,\n")
                .append("\tBranch regA (Rel 2),\n");

        String thenStatement = visit(ctx.stat(0));
        if (ctx.stat(1) == null){ // no 'elseways' statement
            int thenStatLength = countProgramLength(thenStatement);
            stat.append("\tJump (Rel (").append(thenStatLength + 1).append(")),\n")
                .append("\t--then\n")                           // HASKELL COMMENT
                .append(thenStatement)
                .append("\t--then end\n");                      // HASKELL COMMENT

        } else {
            String elseStatement = visit(ctx.stat(1));
            int elseStatLength = countProgramLength(elseStatement);
            thenStatement += "\tJump (Rel (" + (elseStatLength + 1) + ")),\n";
            int thenStatLength = countProgramLength(thenStatement);
            stat.append("\tJump (Rel (").append(thenStatLength+1).append(")),\n")
                    .append("\t--then\n")                       // HASKELL COMMENT
                    .append(thenStatement)
                    .append("\t--then end\n")
                    .append("\t--else\n")                       // HASKELL COMMENT
                    .append(elseStatement)
                    .append("\t--else end\n");                  // HASKELL COMMENT
        }
        return stat.toString();
    }

    @Override
    public String visitLoopStat(LoopStatContext ctx){
        StringBuilder stat = new StringBuilder();
        stat.append(openScope());
        addVariable("__continue", Type.WILDCARD);
        addVariable("__break", Type.WILDCARD);
        stat.append (visit(ctx.stat(0)));   // begin statement

        String conditionExpr = visit(ctx.expr());
        int conditionLength = countProgramLength(conditionExpr);
        String endStat = visit(ctx.stat(1));
        int endStatLen = countProgramLength(endStat);
        String body = visit(ctx.stat(2));
        body += " \tLoad (IndAddr regF) regE,\n" +
                "\tJump (Ind regE),\n";
        int bodyStatLen = countProgramLength(body);

        // insert the address of where the program counter will go when executing 'continue' or finishing
        // body to memory in variable '__continue'
        stat.append("\tLoad (ImmValue (").append(7).append(")) regC,\n")
                .append("\tCompute Add regPC regC regC,\n")
                .append("\tStore regC (IndAddr regF),\n");
        // insert the address of where the program counter will go when executing 'break' to memory in variable
        // '__break'
        stat.append("\tLoad (ImmValue (").append(3 + endStatLen + conditionLength + 3).append(")) regC,\n")
                .append("\tCompute Add regPC regC regC,\n")
                .append("\tCompute Incr regF regF regE,\n")
                .append("\tStore regC (IndAddr regE),\n");
        // on first iteration, jump to condition first
        stat.append("\tJump (Rel (").append(endStatLen + 1).append(")),\n");
        // insert end statement
        stat.append(endStat);
        // insert the condition and program jump
        stat.append(conditionExpr)
                .append("\tPop regA,\n")
                .append("\tBranch regA (Rel 2),\n")
                .append("\tJump (Rel (").append(bodyStatLen + 1).append(")),\n");
        // insert loop body
        stat.append(body);

        stat.append(closeScope());
        return stat.toString();
    }

    @Override
    public String visitBlockStat(BlockStatContext ctx){
        StringBuilder stat = new StringBuilder();
        stat.append("\t--block start\n");       // HASKELL COMMENT
        stat.append(openScope());

        for (int i = 0, k = ctx.stat().size();i < k;i++)
            stat.append(visit(ctx.stat(i)));

        stat.append(closeScope());
        stat.append("\t--block end\n");         // HASKELL COMMENT
        return stat.toString();
    }

    @Override
    public String visitParallelStat(ParallelStatContext ctx){
        StringBuilder stat = new StringBuilder();

        int calledThread = getNextAvailableThreadIndex();
        if (calledThread == -1) errors.add("Numbers of threads not sufficient");

        stat.append("\tCompute Equal reg0 regSprID regD,\n")
                .append("\tBranch regD (Rel 2),\n")     // thread 0 calls next thread
                .append("\tJump (Rel 5),\n")            // other threads start execution
                // calling next thread
                .append("\tLoad (ImmValue (").append(2).append(")) regD,\n")
                .append("\tCompute Add regPC regD regD,\n")
                .append("\tWriteInstr regD (DirAddr (").append(calledThread).append(")),\n");

        stat.append(openScope());
        for (int i = 0 ,l = ctx.stat().size(); i < l; i++)
            stat.append(visit(ctx.stat(i)));
        stat.append(closeScope());

        // if thread id == called thread, write 2 to shared memory in index of thread id
        // and go back
        stat.append("\tLoad (ImmValue (").append(calledThread).append(")) regD,\n")
                .append("\tCompute NEq regSprID regD regD,\n")
                .append("\tBranch regD (Rel 4),\n")    // threads not equal to called thread jump
                .append("\tLoad (ImmValue 2) regD,\n")
                .append("\tWriteInstr regD (DirAddr (").append(calledThread).append(")),\n")
                .append("\tJump (Abs 2),\n");

        // WAIT for the called thread to finish by trying to read 2 from called thread id index
        // on shared memory
        stat.append("\tLoad (ImmValue 2) regC,\n")
                .append("\tReadInstr (DirAddr (").append(calledThread).append(")),\n")
                .append("\tReceive regD,\n")
                .append("\tCompute NEq regC regD regD,\n")
                .append("\tBranch regD (Rel (-3)),\n");
        threadActive[calledThread] = false;
        return stat.toString();
    }

    @Override
    public String visitCritSectionStat(CritSectionStatContext ctx){
        StringBuilder stat = new StringBuilder();
        int lockIndex = locksIndexes.remove(0);
        stat.append("\tTestAndSet (DirAddr (").append(lockIndex).append(")),\n")
            .append("\tReceive regD,\n")
            .append("\tBranch regD (Rel 2),\n")
            .append("\tJump (Rel (-3)),\n");

        stat.append(openScope());
        for (int i = 0 ,l = ctx.stat().size(); i < l; i++)
            stat.append(visit(ctx.stat(i)));
        stat.append(closeScope());

        // delay releasing lock for changes to shared memory to take effect
        stat.append("\tNop,\n".repeat(CHANNEL_DELAY));

        // release lock
        stat.append("\tWriteInstr reg0 (DirAddr (").append(lockIndex).append(")),\n");

        return stat.toString();
    }

    @Override
    public String visitBreakStat(BreakStatContext ctx){
        StringBuilder stat = new StringBuilder();
        int relMemoryOffset = getLastDeclaredVariableOffset("__break");
        stat.append("\t --break\n");                    // HASKELL COMMENT
        stat.append("\tLoad (ImmValue (").append(relMemoryOffset - 1).append(")) regE,\n")
                .append("\tCompute Add regE regF regF,\n")
                .append("\tCompute Incr regF regF regE,\n")
                .append("\tLoad (IndAddr regE) regE,\n")
                .append("\tJump (Ind regE),\n");
        return stat.toString();
    }

    @Override
    public String visitContinueStat(ContinueStatContext ctx){
        StringBuilder stat = new StringBuilder();
        int relMemoryOffset = getLastDeclaredVariableOffset("__continue");
        stat.append("\t --continue\n");                 // HASKELL COMMENT
        stat.append("\tLoad (ImmValue (").append(relMemoryOffset).append(")) regE,\n")
                .append("\tCompute Add regE regF regF,\n")
                .append("\tLoad (IndAddr regF) regE,\n")
                .append("\tJump (Ind regE),\n");
        return stat.toString();
    }

    @Override
    public String visitDoNothingStat(DoNothingStatContext ctx){
        return "\tNop,\n";
    }

    @Override
    public String visitPrintStat(PrintStatContext ctx){
        StringBuilder stat = new StringBuilder();
        String id = ctx.ID().getText();
        MemoryContent var = getVariable(id);

        Type type = null;
        if (var instanceof SharedVariable sharedVar){ // shared variable
            int indexSharedMem = getSharedVariableAndIndex(sharedVar.getName()).snd();
            type = sharedVar.getType();
            stat.append("\tReadInstr (DirAddr (").append(indexSharedMem).append(")),\n")
                    .append("\tReceive regA,\n");
        } else if (var instanceof Variable localVar) { // local variable
            int relMemoryOffset = getLastDeclaredVariableOffset(id);
            type = localVar.getType();
            stat.append("\tLoad (ImmValue (").append(relMemoryOffset).append(")) regE,\n")
                    .append("\tCompute Add regE regF regE,\n")
                    .append("\tLoad (IndAddr regE) regA,\n");
        }
        if (type.equals(Type.INTEGER)){
            stat.append("\tWriteInstr regA numberIO,\n");
        } else if (type.equals(Type.CHARACTER)){
            stat.append("\tWriteInstr regA charIO,\n");
        } else if (type.equals(Type.BOOLEAN)){
            stat.append("\tBranch regA (Rel (7))")
                    .append("\tLoad (ImmValue (ord 'n')) regA,\n")
                    .append("\tWriteInstr regA charIO,\n")
                    .append("\tLoad (ImmValue (ord 'o')) regA,\n")
                    .append("\tWriteInstr regA charIO,\n")
                    .append("\tLoad (ImmValue (ord '-')) regA,\n")
                    .append("\tWriteInstr regA charIO,\n")
                    .append("\tLoad (ImmValue (ord 'g')) regA,\n")
                    .append("\tWriteInstr regA charIO,\n")
                    .append("\tLoad (ImmValue (ord 'o')) regA,\n")
                    .append("\tWriteInstr regA charIO,\n");
        }
        stat.append("\tLoad (ImmValue (ord '\\n')) regA,\n")
                .append("\tWriteInstr regA charIO,\n");

        return stat.toString();
    }

    @Override
    public String visitPrefixExpr(PrefixExprContext ctx) {
        StringBuilder stat = new StringBuilder();
        String expr = visit(ctx.expr());
        String prefixOp = visit(ctx.prefixOp());
        stat.append(expr)
                .append("\tPop regA,\n")
                .append("\tCompute ").append(prefixOp).append(" regA regA regA,\n")
                .append("\tPush regA,\n");
        return stat.toString();
    }

    @Override public String visitNegate(NegateContext ctx){return "Negate";}
    @Override public String visitNot(NotContext ctx){return "Not";}

    @Override
    public String visitExpoExpr(ExpoExprContext ctx) {
        StringBuilder stat = new StringBuilder();
        String leftExpr = visit(ctx.expr(0));
        String rightExpr = visit(ctx.expr(1));
        stat.append(leftExpr).append(rightExpr)
                .append("\tPop regB,\n").append("\tPop regA,\n")
                .append("\tCompute Pow regA regB regA,\n")
                .append("\tPush regA,\n");
        return stat.toString();
    }

    @Override
    public String visitMultDivExpr(MultDivExprContext ctx) {
        StringBuilder stat = new StringBuilder();
        String leftExpr = visit(ctx.expr(0));
        String rightExpr = visit(ctx.expr(1));
        String multDivOp = visit(ctx.multOp());
        stat.append(leftExpr).append(rightExpr)
                .append("\tPop regB,\n").append("\tPop regA,\n")
                .append("\tCompute ").append(multDivOp).append(" regA regB regA,\n")
                .append("\tPush regA,\n");
        return stat.toString();
    }

    @Override public String visitMultiply(MultiplyContext ctx) { return "Mul"; }
    @Override public String visitDivide(DivideContext ctx) { return "Div"; }

    @Override
    public String visitAddMinExpr(AddMinExprContext ctx) {
        StringBuilder stat = new StringBuilder();
        String leftExpr = visit(ctx.expr(0));
        String rightExpr = visit(ctx.expr(1));
        String addMinOp = visit(ctx.addOp());
        stat.append(leftExpr).append(rightExpr)
                .append("\tPop regB,\n").append("\tPop regA,\n")
                .append("\tCompute ").append(addMinOp).append(" regA regB regA,\n")
                .append("\tPush regA,\n");
        return stat.toString();
    }

    @Override public String visitPlus(PlusContext ctx){return "Add";}
    @Override public String visitMinus(MinusContext ctx){return "Sub";}

    public String visitCompareExpr(CompareExprContext ctx) {
        StringBuilder stat = new StringBuilder();
        String leftExpr = visit(ctx.expr(0));
        String rightExpr = visit(ctx.expr(1));
        String compareOp = visit(ctx.compOp());
        stat.append(leftExpr).append(rightExpr)
                .append("\tPop regB,\n").append("\tPop regA,\n")
                .append("\tCompute ").append(compareOp).append(" regA regB regA,\n")
                .append("\tPush regA,\n");
        return stat.toString();
    }

    @Override public String visitEqual(EqualContext ctx) {return "Equal";}
    @Override public String visitNotEqual(NotEqualContext ctx) { return "NEq";}
    @Override public String visitLessThan(LessThanContext ctx) { return "Lt"; }
    @Override public String visitGreaterThan(GreaterThanContext ctx) { return "Gt"; }
    @Override public String visitLessEqual(LessEqualContext ctx) { return "LtE"; }
    @Override public String visitGreaterEqual(GreaterEqualContext ctx) { return "GtE";}

    @Override
    public String visitBitwiseOpExpr(BitwiseOpExprContext ctx) {
        StringBuilder stat = new StringBuilder();
        String leftExpr = visit(ctx.expr(0));
        String rightExpr = visit(ctx.expr(1));
        String bitwiseOp = visit(ctx.bitwiseOp());
        stat.append(leftExpr).append(rightExpr)
                .append("\tPop regB,\n").append("\tPop regA,\n")
                .append("\tCompute ").append(bitwiseOp).append(" regA regB regA,\n")
                .append("\tPush regA,\n");
        return stat.toString();
    }

    @Override public String visitAnd(AndContext ctx){return "And";}
    @Override public String visitOr(OrContext ctx){return "Or";}
    @Override public String visitXor(XorContext ctx){return "Xor";}

    @Override
    public String visitShiftOpExpr(ShiftOpExprContext ctx){
        StringBuilder stat = new StringBuilder();
        String leftExpr = visit(ctx.expr(0));
        String rightExpr = visit(ctx.expr(1));
        String shiftOp = visit(ctx.shiftOp());
        stat.append(leftExpr).append(rightExpr)
                .append("\tPop regB,\n").append("\tPop regA,\n")
                .append("\tCompute ").append(shiftOp).append(" regA regB regA,\n")
                .append("\tPush regA,\n");
        return stat.toString();
    }

    @Override public String visitLshift(LshiftContext ctx){return "LShift";}
    @Override public String visitRshift(RshiftContext ctx){return "RShift";}

    @Override
    public String visitParensExpr(ParensExprContext ctx){
        return visit(ctx.expr());
    }

    @Override
    public String visitIdExpr(IdExprContext ctx){
        StringBuilder expr = new StringBuilder();
        String id = ctx.ID().getText();
        if (sharedVariablesNames.contains(id)){
            TwoTuple<SharedVariable, Integer> sharedVariable = getSharedVariableAndIndex(id);
            expr.append("\tReadInstr (DirAddr (").append(sharedVariable.snd()).append(")),\n")
                    .append("\tReceive regA,\n")
                    .append("\tPush regA,\n");
        } else {
            int relMemoryOffset = getLastDeclaredVariableOffset(id);
            expr.append("\tLoad (ImmValue (").append(relMemoryOffset).append(")) regE,\n")
                    .append("\tCompute Add regE regF regE,\n")
                    .append("\tLoad (IndAddr regE) regA,\n")
                    .append("\tPush regA,\n");

        }
        return expr.toString();
    }

    @Override
    public String visitIntegerExpr(IntegerExprContext ctx){
        StringBuilder expr = new StringBuilder();
        expr.append("\tLoad (ImmValue (").append(ctx.INTEGER().getText()).append(")) regA,\n")
                .append("\tPush regA,\n");
        return expr.toString();
    }

    @Override
    public String visitBooleanExpr(BooleanExprContext ctx){
        StringBuilder expr = new StringBuilder();
        String bool = ctx.BOOLEAN().getText().equals("go") ? "1" : "0";
        expr.append("\tLoad (ImmValue (").append(bool).append(")) regA,\n")
                .append("\tPush regA,\n");
        return expr.toString();
    }

    @Override
    public String visitCharExpr(CharExprContext ctx){
        StringBuilder expr = new StringBuilder();
        expr.append("\tLoad (ImmValue (ord ").append(ctx.CHARLITERAL().getText()).append(")) regA,\n")
                .append("\tPush regA,\n");
        return expr.toString();
    }

    /**
     * Get the SprIL instructions to open a scope, i.e. increasing scope base address in memory.
     * @return the SprIL instructions of opening a scope
     */
    private String openScope(){
        StringBuilder builder = new StringBuilder();
        int currentScopeSize = getScopeTotalSize(variablesOffsets.get(variablesOffsets.size() - 1));
        builder.append("\tLoad (ImmValue (").append(currentScopeSize).append(")) regE,\n")
                .append("\tCompute Add regE regF regF,\n");
        variablesOffsets.add(new ArrayList<>());
        return builder.toString();
    }

    /**
     * Get the SprIL instructions to close a scope, i.e. decreasing base scope base address in memory.
     * @return the SprIL instructions of closing a scope
     */
    private String closeScope(){
        StringBuilder builder = new StringBuilder();
        int previousScopeSize = getScopeTotalSize(variablesOffsets.get(variablesOffsets.size() - 2));
        builder.append("\tLoad (ImmValue (").append(previousScopeSize).append(")) regE,\n")
                .append("\tCompute Sub regF regE regF,\n");
        variablesOffsets.remove(variablesOffsets.size() - 1);
        return builder.toString();
    }

    /**
     * Get the shared variables with the given name and its index on shared memory.
     * @param id name of the variable
     * @return a two-tuple containing the shared integer and its index on shared memory.
     */
    private TwoTuple<SharedVariable,Integer> getSharedVariableAndIndex(String id){
        int shMemIndex = 0;
        for (MemoryContent memoryContent : sharedMemory) {
            if (memoryContent instanceof SharedVariable sharedVar) {
                if (sharedVar.getName().equals(id)) return new TwoTuple<>(sharedVar, shMemIndex);
                else shMemIndex += sharedVar.getLengthInMemory();
            } else
                shMemIndex++;
        }
        return null;
    }

    /** Add a variable in the current scope.
     * @param id name of the variable
     * @param type type of the variable
     */
    private void addVariable(String id ,Type type){
        int nextOffset = getNextStartOffset();
        int variableSize = 1;

        // can be extended with else statement for arrays (NOT YET SUPPORTED)
        if (type.equals(Type.INTEGER) || type.equals(Type.BOOLEAN) || type.equals(Type.CHARACTER)) variableSize = 1;

        Variable var = new Variable(id, nextOffset, (nextOffset + variableSize - 1), type);
        variablesOffsets.get(variablesOffsets.size() - 1).add(var);
    }

    /**
     * Get next available offset relative to the current scope base address
     * @return the next offset relative to the current scope base address that is free
     */
    private int getNextStartOffset(){
        ArrayList<Variable> currentScope = variablesOffsets.get(variablesOffsets.size() - 1);
        if (currentScope.size() == 0) return 0;
        else {
            Variable lastVariable = currentScope.get(currentScope.size() - 1);
            return lastVariable.getEndOffset() + 1;
        }
    }

    /**
     * Get the offset of the latest variable declared with the given name relative to the current scope base address.
     * @param id identifier of the variable
     * @return the relative offset from the current scope offset
     */
    private int getLastDeclaredVariableOffset(String id){
        int offset = 0;
        for (int i = variablesOffsets.size() - 1; i >= 0 ;i--){
            ArrayList<Variable> currScopeVars = variablesOffsets.get(i);
            int relativeOffset = 0;
            for (Variable var : currScopeVars){
                if (var.getName().equals(id)) return offset + relativeOffset;
                else relativeOffset += (var.getEndOffset() - var.getStartOffset() + 1);
            }
            if (i > 0) offset -= getScopeTotalSize(variablesOffsets.get(i - 1));
        }
        return -1;
    }

    /**
     * Get the variable/shared variable with the given name
     * @param id identifier of the variable
     * @return the variable/shared variable representation
     */
    private MemoryContent getVariable(String id){
        if (sharedVariablesNames.contains(id)){ // shared variable
            for (int i = 0, len = sharedMemory.size(); i < len; i++)
                if ((sharedMemory.get(i) instanceof SharedVariable sharedVar) && sharedVar.getName().equals(id))
                    return sharedVar;
        } else { // local variable
            for (int i = variablesOffsets.size() - 1; i > 0; i--)
                for (Variable var : variablesOffsets.get(i))
                    if (var.getName().equals(id)) return var;
        }
        return null;
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

    /**
     * Count the length of a program by counting the number of substring ",\n".
     * @param program the program text
     * @return the length of the program
     */
    private int countProgramLength(String program){
        int count = 0;
        for (int i = 0,len = program.length();i < len ;i++) {
            if (program.charAt(i) == ',' && program.charAt(i+1) == '\n') count++;
        }
        return count;
    }

    /**
     * Get next available thread index on shared memory.
     * @return the thread number
     */
    private int getNextAvailableThreadIndex(){
        for (int i = 0; i < threadActive.length; i++){
            if (!threadActive[i]) {
                threadActive[i] = true;
                return i;
            }
        }
        return -1;
    }

    private void initializeConverter(Result res) {
        this.result = res;
        this.errors = new ArrayList<>();

        // get required number of threads
        int numberOfThreads = result.getThreadsNeeded();

        // get all shared variables total size
        // integers, chars, and booleans have size of 1.
        int sharedVarSize = 0;
        for (TwoTuple<String, Type> sharedVar: result.getSharedVariables()) {
            if (sharedVar.snd().equals(Type.INTEGER) || sharedVar.snd().equals(Type.BOOLEAN)
                    || sharedVar.snd().equals(Type.CHARACTER)) sharedVarSize++;
        }

        // get the number of locks needed for critical sections
        int criticalSectionLocks = result.getCriticalSectionCount();

        // Check if shared memory is sufficient for storing all threads start addresses, shared variables, and critical
        // section lock.
        if ((numberOfThreads + sharedVarSize + criticalSectionLocks) > SHARED_MEM_SIZE){
            errors.add("Shared memory size insufficient. Required memory size: "
                    + (numberOfThreads + sharedVarSize + criticalSectionLocks));
        }

        variablesOffsets = new ArrayList<>();
        threadActive = new boolean[numberOfThreads];
        sharedMemory = new ArrayList<>();
        sharedVariablesNames = new HashSet<>();

        int idx = 0;
        // allocate memory for threads start addresses
        for (int i = 0;i < numberOfThreads;i++) {
            sharedMemory.add(new ThreadStartAddress(i));
            idx++;
        }

        // allocate memory for shared variables
        for (TwoTuple<String, Type> sharedVar : result.getSharedVariables()){
            Type sharedVarType = sharedVar.snd();
            if (sharedVarType.equals(Type.INTEGER) || sharedVarType.equals(Type.BOOLEAN)
                || sharedVarType.equals(Type.CHARACTER)){
                sharedMemory.add(new SharedVariable(sharedVar.fst(), sharedVar.snd(), 1));
                idx++;
            }

            if (!sharedVariablesNames.add(sharedVar.fst()))
                errors.add("Duplicate shared variable name");
        }

        locksIndexes = new ArrayList<>();
        for (int j = 0; j < criticalSectionLocks; j++){
            sharedMemory.add(new Lock("Lock " + j));
            locksIndexes.add(idx);
            idx++;
        }

    }

    public String convertToSpril(ParseTree tree, Result result){
        if (result == null) return null;
        initializeConverter(result);
        if (errors.size() > 0){
            errors.forEach(System.out::println);
            return null;
        }

        String converted = visit(tree);
        if (errors.size() > 0){
            errors.forEach(System.out::println);
            return null;
        }
        return converted;
    }

}
