package type_checking;

/** Representing the primitive data types of the D programming language.
 *  Static instances represent the data types of this
 */
public class Type {

    /** The primitive data types represented as instances of this class. */
    public final static Type INTEGER = new Type("int");
    public final static Type BOOLEAN = new Type("bool");
    public final static Type CHARACTER = new Type("char");
    public final static Type STRING = new Type("str");
    public final static Type ERROR = new Type(null);

    /** Special data type, indicating that the expression can be of any type.
     *  Used by empty arrays to use this as their base type.
     */
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

}
