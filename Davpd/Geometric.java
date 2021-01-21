public class Geometric extends NegativeBinomial{
    public Geometric () {
        super("images/Geométrica.jpg", "texts/Geoemtrica.txt", 0.0, 1);
    }
    public Geometric (double p){
        this();
        super.p = p;
    }
    @Override
    public String toString() {
        return String.format("X ~ G(x = %d; p = %f)", var, p);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Davpd){
            Geometric geometric = (Geometric) obj;
            if(geometric.p == p)
                return true;
        }
        return false;
    }
}
