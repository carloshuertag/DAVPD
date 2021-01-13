package Model;

public class NegativeBinomial extends Davpd{
    protected double p;
    protected int k;
    public NegativeBinomial () { }
    public NegativeBinomial (String description, String function, String cumulative, String mean, String variance, double p, int k){
        super(description, function, cumulative, mean, variance);
        this.p = p;
        this.k = k;
    }
    public void setP(double p) throws Exception{
        if(!(p <= 1 && p > 0))
            throw new Exception("p must be between (0, 1]");
        this.p = p;
    }
    public double getP(){ return p; }
    public void setK(int k){ this.k = k; }
    public double getK(){ return k; }
    @Override
    public double getValue(){
        return CountingTechniques.combinatorial(var - 1, k - 1) * Math.pow(p, k) * Math.pow(1 - p, var - k);
    }
    @Override
    public double getCumulativeValue(){
        cumulativeValue = 0;
        double tmp = var;
        for(int i = k; i < var; i++){
            var = i + 0.0;
            cumulativeValue += getValue();
        }
        var = tmp;
        return cumulativeValue;
    }
    @Override
    public double getMeanValue(){ 
        return (k + 0.0) / p;
    }
    @Override
    public double getVarianceValue(){
        return (k * (1 - p)) / Math.pow(p, 2.0);
    }
    @Override
    public String toString() {
        return String.format("X ~ NB(x = %d; p = %d, k = %d)", var, p, k);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof NegativeBinomial){
            NegativeBinomial negativeBinomial = (NegativeBinomial) obj;
            if(negativeBinomial.p == p && negativeBinomial.k == k)
                return true;
        }
        return false;
    }
}
