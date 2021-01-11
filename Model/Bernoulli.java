public class Bernoulli extends Davpd{
    private double p;
    public Bernoulli () { }
    public Bernoulli (String name, String description, String function, String cumulative, String mean, String variance, double p){
        super(description, function, cumulative, mean, variance);
        this.p = p;
    }
    public void setP(double p){ this.p = p; }
    public double getP(){return p; }
    @Override
    public double getValue(){
        return Math.pow(p, super.var) * Math.pow(1 - p, 1 - super.var);
    }
    @Override
    public double getCumulativeValue(){
        if(super.var < 0)
            return 0;
        if(super.var >= 1)
            return p;
        return 1 - p;
    }
    @Override
    public double getMeanValue(){ 
        return p;
    }
    @Override
    public double getVarianceValue(){
        return p * (1 - p);
    }
    @Override
    public String toString() {
        return String.format("X ~ Ber(x = %d; p = &d)", super.var, p);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Bernoulli){
            Bernoulli bernoulli = (Bernoulli) obj;
            if(bernoulli.p == p)
                return true;
        }
        return false;
    }
}
