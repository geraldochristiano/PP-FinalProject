
public class Type {

    /** The primitive data types represented as instances of this class. */
    public final static Type INTEGER = new Type("int");
    public final static Type BOOLEAN = new Type("bool");
    public final static Type CHARACTER = new Type("char");
    public final static Type STRING = new Type("str");
    public final static Type ERROR = new Type(null);

    /** Keyword of the data types as they exist in the grammar*/
    private String keyword;

    /** Constructor is made private to prevent instantiation from outside this class*/
    private Type(String keyword){
        this.keyword = keyword;
    }

    /**
     * Representing the array data type. An array have a dimension value representing its dimension and
     * a primitive data type representing the base type, i.e. the data type of the last dimension of the array.
     * The class OVERRIDES 'equals' method to be the comparison operator/method of this class.
     * Two array data types are equal if they both have the same number of dimensions and base type.
     */
    static class ArrayType{
        private Type baseType;

        private int dimension;

        public ArrayType(Type baseType, int dimension){
            this.baseType = baseType;
            this.dimension = dimension;
        }

        public Type getBaseType(){
            return this.baseType;
        }

        public int getDimension(){
            return this.dimension;
        }

        @Override
        public boolean equals(Object obj){
            if (! (obj instanceof ArrayType compare)) return false;
            return (compare.getBaseType() == this.getBaseType()) && (compare.getDimension() == this.getDimension());
        }

    }
}
