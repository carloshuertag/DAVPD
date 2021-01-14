public class Binomial extends Davpd{
    private double p;
    private int n;
    public Binomial () { }
    public Binomial (double p, int n){
        super("images/BinomialD.jpg", "images/BinomialF.jpg", "images/BinomialC.jpg", "images/BinomialM.jpg", "images/BinomialV.jpg");
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
        return CountingTechniques.combinatorial(n + 0.0, var + 0.0) * Math.pow(p, var + 0.0) * Math.pow(1 - p, n - var + 0.0);
    }
    @Override
    public double getCumulativeValue(){
        cumulativeValue = 0;
        int tmp = var;
        for(int i = 0; i < var; i++){
            var = i;
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
        return String.format("X ~ B(x = %d; n = %d, p = %f)", var, n, p);
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
