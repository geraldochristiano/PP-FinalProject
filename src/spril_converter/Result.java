package spril_converter;

import type_checking.Type;

import java.util.ArrayList;
import java.util.List;

public class Result {
    /** Total threads needed*/
    private int threadsNeeded;
    /** Critical section existence in the program*/
    private int criticalSectionCount;
    /** List of shared variables*/
    private List<TwoTuple<String, Type>> sharedVariables;

    public Result(){
        threadsNeeded = 1;
        criticalSectionCount = 0;
        sharedVariables = new ArrayList<>();
    }

    public int getThreadsNeeded() {
        return threadsNeeded;
    }

    public void setThreadsNeeded(int threadsNeeded) {
        this.threadsNeeded = threadsNeeded;
    }

    public int getCriticalSectionCount(){return criticalSectionCount;}

    public void incrementCritSectionCount(){criticalSectionCount++;}

    public List<TwoTuple<String,Type>> getSharedVariables(){
        return sharedVariables;
    }


}
