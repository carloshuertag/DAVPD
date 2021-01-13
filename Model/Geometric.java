package Model;

public class Geometric extends NegativeBinomial{
    public Geometric () { }
    public Geometric (String description, String function, String cumulative, String mean, String variance, double p){
        super(description, function, cumulative, mean, variance, p, 1);
    }
    @Override
    public String toString() {
        return String.format("X ~ G(x = %d; p = &d)", var, p);
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
