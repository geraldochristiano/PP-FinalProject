package spril_converter;

import grammar.DBaseListener;
import grammar.DParser.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class PreConverter extends DBaseListener {

    private Result result;

    private int currentThreads;

    @Override
    public void enterDeclareStat(DeclareStatContext ctx){
        if (ctx.SHARED() != null){
            for (int i = 0; i < ctx.ID().size(); i++){
                result.getSharedVariables().add(ctx.ID(i).getText());
            }
        }
    }

    @Override
    public void enterParallelStat(ParallelStatContext ctx){
        currentThreads *= 2;
        if (result.getThreadsNeeded() < currentThreads){
            result.setThreadsNeeded(currentThreads);
        }
    }

    @Override
    public void exitParallelStat(ParallelStatContext ctx){
        currentThreads /= 2;
    }

    @Override
    public void enterCritSectionStat(CritSectionStatContext ctx){
        result.criticalSectionExist();
    }

    public Result preConvert(ParseTree tree){
        this.result = new Result();
        this.currentThreads = 1;
        ParseTreeWalker.DEFAULT.walk(this,tree);
        return this.result;
    }

}
