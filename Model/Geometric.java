public class Geometric extends Davpd{
    private double p;
    public Geometric () { }
    public Geometric (String description, String function, String cumulative, String mean, String variance, double p){
        super(description, function, cumulative, mean, variance);
        this.p = p;
    }
    public void setP(double p){ this.p = p; }
    public double getP(){ return p; }
    @Override
    public double getValue(){
        return value;
    }
    @Override
    public double getCumulativeValue(){
        return cumulativeValue;
    }
    @Override
    public double getMeanValue(){ 
        return meanValue;
    }
    @Override
    public double getVarianceValue(){
        return varianceValue;
    }
    @Override
    public String toString() {
        return String.format("X ~ %s(%d)", description, value);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Davpd){
            Davpd davpd = (Davpd) obj;
            if(davpd.function == function)
                return true;
        }
        return false;
    }
}
