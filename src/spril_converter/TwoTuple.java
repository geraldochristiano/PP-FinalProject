package spril_converter;

public class TwoTuple <X,Y>{
    private X x;
    private Y y;

    public TwoTuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X fst() {
        return this.x;
    }

    public void fst(X val){this.x = val;}

    public Y snd() {
        return this.y;
    }

    public void snd(Y val){this.y = val;}
}
