package spril_converter;

import type_checking.Type;

/**
 * Shared variables representation in (shared) memory.
 */
public class SharedVariable extends MemoryContent{

    private final Type sharedVarType;

    private final int lengthInMemory;

    public SharedVariable(String sharedVariableName, Type type, int lengthInMemory){
        super(sharedVariableName);
        sharedVarType = type;
        this.lengthInMemory = lengthInMemory;
    }

    public int getLengthInMemory() {
        return lengthInMemory;
    }

    public Type getType(){
        return sharedVarType;
    }
}
