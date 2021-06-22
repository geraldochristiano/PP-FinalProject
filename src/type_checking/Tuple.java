package type_checking;

public class Tuple<X, Y> {
    public final X x;
    public final Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }

    public X fst() {
        return this.x;
    }

    public Y snd() {
        return this.y;
    }
}
