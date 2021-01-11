public class Poisson extends Davpd{
    private double lamda;
    public Poisson () { }
    public Poisson (String description, String function, String cumulative, String mean, String variance, double lamda){
        super(description, function, cumulative, mean, variance);
        this.lamda = lamda;
    }
    public void setLamda(double lamda){ this.lamda = lamda; }
    public double getLamda(){ return lamda; }
    @Override
    public double getValue(){
        return Math.exp(-lamda) * Math.pow(lamda, var) / CountingTechniques.factorial(var);
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
        return lamda;
    }
    @Override
    public double getVarianceValue(){
        return lamda;
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
