public class Bernoulli extends Davpd{
    private double p;
    public Bernoulli () { }
    public Bernoulli (double p){
        super("images/BernoulliD.jpg", "images/BernoulliF.jpg", "images/BernoulliC.jpg", "images/BernoulliM.jpg", "images/BernoulliV.jpg");
        this.p = p;
    }
    public void setP(double p) throws Exception{
        if(!(p <= 1 && p > 0))
            throw new Exception("p must be between (0, 1]");
        this.p = p;
    }
    public double getP(){return p; }
    @Override
    public double getValue(){
        return Math.pow(p, var) * Math.pow(1 - p, 1 - var);
    }
    @Override
    public double getCumulativeValue(){
        if(var < 0)
            return 0;
        if(var >= 1)
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
        return String.format("X ~ Ber(x = %d; p = %f)", var, p);
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
