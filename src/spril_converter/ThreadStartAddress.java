package spril_converter;

/**
 * Threads start addresses representation in (shared) memory.
 */
public class ThreadStartAddress extends MemoryContent{

    private int threadNumber;

    public ThreadStartAddress(int threadNumber){
        super("Thread " + threadNumber);
        this.threadNumber = threadNumber;
    }

    public int getThreadNumber(){return threadNumber;}
}
