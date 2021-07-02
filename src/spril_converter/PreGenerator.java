package spril_converter;

import grammar.DBaseListener;
import grammar.DParser.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import type_checking.Type;

/**
 *
 */
public class PreGenerator extends DBaseListener {

    public static final PreGenerator INSTANCE = new PreGenerator();

    private Result result;

    private int currentThreads;

    @Override
    public void enterDeclareStat(DeclareStatContext ctx){
        if (ctx.SHARED() != null){
            Type type = null;
            switch (ctx.dataType().getText()) {
                case "int" -> type = Type.INTEGER;
                case "bool" -> type = Type.BOOLEAN;
                case "char" -> type = Type.CHARACTER;
            }
            result.getSharedVariables().add(new TwoTuple<>(ctx.ID().getText(), type));
        }
    }

    @Override
    public void enterAssignStat(AssignStatContext ctx){
        if ((ctx.SHARED() != null) && (ctx.dataType() != null)){
            Type type = null;
            switch (ctx.dataType().getText()) {
                case "int" -> type = Type.INTEGER;
                case "bool" -> type = Type.BOOLEAN;
                case "char" -> type = Type.CHARACTER;
            }
            result.getSharedVariables().add(new TwoTuple<>(ctx.ID().getText(), type));

        }
    }

    @Override
    public void enterParallelStat(ParallelStatContext ctx){
        currentThreads++;
        if (result.getThreadsNeeded() < currentThreads){
            result.setThreadsNeeded(currentThreads);
        }
    }

    @Override
    public void exitParallelStat(ParallelStatContext ctx){
        currentThreads--;
    }

    @Override
    public void enterCritSectionStat(CritSectionStatContext ctx){
        result.incrementCritSectionCount();
    }

    public Result preConvert(ParseTree tree){
        this.result = new Result();
        this.currentThreads = 1;
        ParseTreeWalker.DEFAULT.walk(this,tree);
        return this.result;
    }

}
