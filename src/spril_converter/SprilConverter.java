package spril_converter;

import grammar.DBaseVisitor;
import grammar.DParser.*;
import org.antlr.v4.runtime.tree.ParseTree;
import type_checking.Tuple;

import java.util.ArrayList;
import java.util.HashMap;

public class SprilConverter extends DBaseVisitor<String> {

    public static final SprilConverter INSTANCE = new SprilConverter();

    private static final int LOCAL_MEM_SIZE = 32;
    private static final int SHARED_MEM_SIZE = 8;
    private static final int REGISTER_SIZE = 8;
    private static final int REGISTER_SPR_ID = 1;

    private ArrayList<String> errors;
    private ArrayList<ArrayList<Tuple<String, Integer, Integer>>> variables;
    private Result result;
    public boolean[] threadActive;
    public boolean[] registersInUse;

    @Override
    public String visitProgram (ProgramContext ctx){
        threadActive[0] = true; // Thread 0 active
        registersInUse[0] = true; // reg0
        registersInUse[1] = true; // regSprID
        StringBuilder program = new StringBuilder();
        program.append("import Sprockell\n").append("prog::[Instruction]\n").append("prog = [");
        if (threadActive.length > 1){
            program.append("Compute Equal reg0 regSprID regA,\n").append("Branch regA (Rel 5)");
            program.append("ReadInstr (Ind)");
        }
        for (StatContext stat : ctx.stat()){
            String children = visit(stat);
            program.append(children).append("\n");
        }
    }


    private String getAnAvailableThread(){
        for (int i = 0; i < threadActive.length; i++){
            if (!threadActive[i]){
                return String.valueOf(i);
            }
        }
        return null;
    }

    private boolean initialize(Result res) {
        variables = new ArrayList<>();
        result = res;
        errors = new ArrayList<>();
        int numberOfThreads = result.getThreadsNeeded();
        int sharedVarSize = result.getSharedVariables().size();
        int lock = result.getCriticalSectionExist() ? 1 : 0;
        if ((numberOfThreads + sharedVarSize + lock) < SHARED_MEM_SIZE){
            errors.add("Shared memory size insufficient.");
            return false;
        }
        threadActive = new boolean[numberOfThreads];
        registersInUse = new boolean[REGISTER_SIZE];
        return true;
    }



    public String convertToSpril(ParseTree tree, Result result){
        if (result == null) return null;
        if (!initialize(result)){
            errors.forEach(System.out::println);
            return null;
        }

    }
}
