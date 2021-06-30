package spril_converter;

import org.antlr.v4.runtime.RuleContext;
import type_checking.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Result {
    /** Total threads needed*/
    private int threadsNeeded = 1;
    /** Critical section existence in the program*/
    private boolean criticalSectionExist;
    /** List of shared variables*/
    private List<TwoTuple<String, Type>> sharedVariables;

    public int getThreadsNeeded() {
        return threadsNeeded;
    }

    public void setThreadsNeeded(int threadsNeeded) {
        this.threadsNeeded = threadsNeeded;
    }

    public boolean getCriticalSectionExist(){return criticalSectionExist;}

    public void criticalSectionExist(){criticalSectionExist = true;}

    public List<TwoTuple<String,Type>> getSharedVariables(){
        return sharedVariables;
    }


}
