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
    @Override
    public double getValue(){
        return CountingTechniques.combinatorial(n + 0.0, super.var) * Math.pow(p, super.var) * Math.pow(1 - p, n - super.var);
    }
    public double getValue(double x){
        return CountingTechniques.combinatorial(n + 0.0, x) * Math.pow(p, x) * Math.pow(1 - p, n - x);
    }
    @Override
    public double getCumulativeValue(){
        super.cumulativeValue = 0;
        for(int i = 0; i < super.var; i++)
            super.cumulativeValue += getValue(i + 0.0);
        return super.cumulativeValue;
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
        return String.format("X ~ B(x = %d; n = %d, p = %d)", super.var, n, p);
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
