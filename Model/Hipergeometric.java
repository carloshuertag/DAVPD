public class Hipergeometric extends Davpd{
    private int r1, r2, n;
    public Hipergeometric () { }
    public Hipergeometric (String name, String description, String function, String cumulative, String mean, String variance, int r1, int r2, int n){
        super(description, function, cumulative, mean, variance);
        this.r1 = r1;
        this.r2 = r2;
        this.n = n;
    }
    public void setR1(int r1){ this.r1 = r1; }
    public double getR1(){ return r1; }
    public void setR2(int r2){ this.r2 = r2; }
    public double getR2(){ return r2; }
    public void setN(int n){ this.n = n; }
    public double getN(){ return n; }
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
