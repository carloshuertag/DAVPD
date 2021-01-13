package Model;

public class Binomial extends Davpd{
    private double p;
    private int n;
    public Binomial () { }
    public Binomial (String description, String function, String cumulative, String mean, String variance, double p, int n){
        super(description, function, cumulative, mean, variance);
        this.p = p;
        this.n = n;
    }
    public void setP(double p) throws Exception{
        if(!(p <= 1 && p > 0))
            throw new Exception("p must be between (0, 1]");
        this.p = p;
    }
    public double getP(){ return p; }
    public void setN(int n){ this.n = n; }
    public double getN(){ return n; }
    @Override
    public double getValue(){
        return CountingTechniques.combinatorial(n + 0.0, var) * Math.pow(p, var) * Math.pow(1 - p, n - var);
    }
    @Override
    public double getCumulativeValue(){
        cumulativeValue = 0;
        double tmp = var;
        for(int i = 0; i < var; i++){
            var = i + 0.0;
            cumulativeValue += getValue();
        }
        var = tmp;
        return cumulativeValue;
    }
    @Override
    public double getMeanValue(){ 
        return n * p;
    }
    @Override
    public double getVarianceValue(){
        return n * p * (1 - p);
    }
    @Override
    public String toString() {
        return String.format("X ~ B(x = %d; n = %d, p = %d)", var, n, p);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Binomial){
            Binomial binomial = (Binomial) obj;
            if(binomial.n == n && binomial.p == p)
                return true;
        }
        return false;
    }
}
