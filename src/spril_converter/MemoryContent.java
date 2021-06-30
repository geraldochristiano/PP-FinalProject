package spril_converter;

/**
 * Provide a common interface for both local memory and shared memory contents.
 */
public abstract class MemoryContent {

    /** Name can be filled with anything.
     *  Used to provide any important information according to classes that extend this class.
     */
    private String name;

    public MemoryContent(String name){
        this.name = name;
    }

    public String getName(){return this.name;}

    public void setName(String name){this.name = name;}
}
