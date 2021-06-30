package type_checking;

import java.util.ArrayList;

/**
 * Representing the array data type. An array have a list of numbers indicating the number of elements in each
 * dimension of the array and a primitive data type representing the base type, i.e. the data type of the last
 * dimension of the array.
 * The class OVERRIDES 'equals' method to be the comparison operator/method of this class.
 * Two array data types are equal if they both have the same number of dimensions and base type.
 */
public class ArrayType extends Type{
    /** Base type of the array*/
    private Type baseType;

    /** Lengths of each dimension of the array*/
    private ArrayList<Integer> lengths;

    public ArrayType(Type baseType, ArrayList<Integer> lengths) {
        super(baseType.getKeyword() + "[]");
        if (baseType instanceof ArrayType) throw new RuntimeException("Base type can not be array type");
        this.baseType = baseType;
        this.lengths = lengths;
    }

    public Type getBaseType(){
        return this.baseType;
    }

    public ArrayList<Integer> getLengths(){return this.lengths;}

    /** This method should be the preferred comparison method than <code>==</code>.
     *  Allows equality when comparing array of wildcard base type.
     */
    @Override
    public boolean equals(Object obj){
        if (! (obj instanceof ArrayType compare)) return false;
        if (compare.baseType == Type.WILDCARD || this.baseType == Type.WILDCARD)
            return compare.lengths.equals(this.lengths);
        else return (compare.baseType.equals(this.baseType) && compare.lengths.equals(this.lengths));
    }

    @Override
    public String toString(){
        StringBuilder repr = new StringBuilder(baseType.getKeyword());
        for (Integer length : lengths) {
            repr.append("[").append(length).append("]");
        }
        return repr.toString();
    }
}
