public class Geometric extends NegativeBinomial{
    public Geometric () { }
    public Geometric (double p){
        super("images/GeometricD.jpg", "images/GeoemtricF.jpg", "images/GeometricC.jpg", "images/GeometricM.jpg", "images/GeometricV.jpg", p, 1);
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
