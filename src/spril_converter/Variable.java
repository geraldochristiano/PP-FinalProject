package spril_converter;

import type_checking.Type;

/**
 * Local variables representation in (local) memory.
 */
public class Variable extends MemoryContent{

    private int startOffset;
    private int endOffset;
    private Type varType;

    public Variable(String varName, int startOffset, int endOffset, Type type){
        super(varName);
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        varType = type;
    }

    public int getStartOffset() {
        return startOffset;
    }

    public int getEndOffset(){
        return endOffset;
    }

    public Type getType(){return varType;}
}
