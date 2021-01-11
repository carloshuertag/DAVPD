public class Poisson extends Davpd{
    private double lamda;
    public Poisson () { }
    public Poisson (String name, String description, String function, String cumulative, String mean, String variance, double lamda){
        super(description, function, cumulative, mean, variance);
        this.lamda = lamda;
    }
    public void setLamda(double lamda){ this.lamda = lamda; }
    public double getLamda(){ return lamda; }
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
