package type_checking;

public class Tuple<X, Y, Z> {
    private X x;
    private Y y;
    private Z z;

    public Tuple(X x, Y y, Z z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public X fst() {
        return this.x;
    }

    public void fst(X val){this.x = val;}

    public Y snd() {
        return this.y;
    }

    public void snd(Y val){this.y = val;}

    public Z thrd(){return this.z;}

    public void thrd(Z val){this.z = val;}
}
