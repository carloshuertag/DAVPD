public class NegativeBinomial extends Davpd{
    private double p;
    private int k;
    public NegativeBinomial () { }
    public NegativeBinomial (String name, String description, String function, String cumulative, String mean, String variance, double p, int k){
        super(description, function, cumulative, mean, variance);
        this.p = p;
        this.k = k;
    }
    public void setP(double p){ this.p = p; }
    public double getP(){ return p; }
    public void setK(int k){ this.k = k; }
    public double getK(){ return k; }
}
