public class Hipergeometric extends Davpd{
    private int r1, r2, n;
    public Hipergeometric () {
        super("images/HipergeomtricD.jpg", "images/HipergeomtricF.jpg", "images/HipergeomtricC.jpg", "images/HipergeomtricM.jpg", "images/HipergeomtricV.jpg");
    }
    public Hipergeometric (int r1, int r2, int n){
        this();
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
        return (CountingTechniques.combinatorial(r1, var) * CountingTechniques.combinatorial(r2, n - var)) / CountingTechniques.combinatorial(r1 + r2, n);
    }
    @Override
    public double getCumulativeValue(){
        cumulativeValue = 0.0;
        int tmp = var;
        for(int i = Math.max(0, n - r2); i < tmp; i++){
            var = i;
            cumulativeValue += getValue();
        }
        var = tmp;
        return cumulativeValue;
    }
    @Override
    public double getMeanValue(){ 
        return (r1 * n) / (r1 + r2);
    }
    @Override
    public double getVarianceValue(){
        return n * (r1 / (r1 + r2)) ;
    }
    @Override
    public String toString() {
        return String.format("X ~ H(x = %d; r1 = %d, r2 = %d, n = %d)", var, r1, r2, n);
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Davpd){
            Hipergeometric hipergeometric = (Hipergeometric) obj;
            if(hipergeometric.r1 == r1 && hipergeometric.r2 == r2 && hipergeometric.n == n)
                return true;
        }
        return false;
    }
}
