package type_checking;

public class Type {

    /** The primitive data types represented as instances of this class. */
    public final static Type INTEGER = new Type("int");
    public final static Type BOOLEAN = new Type("bool");
    public final static Type CHARACTER = new Type("char");
    public final static Type STRING = new Type("str");
    public final static Type ERROR = new Type(null);

    /** Special data type, indicating that the expression can be of any type*/
    public final static Type WILDCARD = new Type("(Any type)");

    /** Keyword of the data types as they exist in the grammar*/
    private String keyword;

    /** Constructor is made protected to prevent instantiation from outside classes that don't extend this class*/
    protected Type(String keyword){
        this.keyword = keyword;
    }

    public String getKeyword() {
        return this.keyword;
    }

    @Override
    public String toString(){
        return this.keyword;
    }

    /** This method should be the preferred comparison method than <code>==</code>.
     *  Allows equality when comparing wildcard type.
     */
    public boolean equals(Object obj){
        if (!(obj instanceof Type type)) return false;
        if (this == Type.WILDCARD || type == Type.WILDCARD)return true;
        else return this == type;
    }
}
