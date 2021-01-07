public class Binomial extends Davpd{
    private double p;
    private int n;
    public Binomial () { }
    public Binomial (String name, String description, String function, String cumulative, String mean, String variance, double p, int n){
        super(description, function, cumulative, mean, variance);
        this.p = p;
        this.n = n;
    }
    public void setP(double p){ this.p = p; }
    public double getP(){ return p; }
    public void setN(int n){ this.n = n; }
    public double getN(){ return n; }
}
