public class Poisson extends Davpd{
    private double lamda;
    public Poisson () { }
    public Poisson (String name, String description, String function, String cumulative, String mean, String variance, double lamda){
        super(description, function, cumulative, mean, variance);
        this.lamda = lamda;
    }
    public void setLamda(double lamda){ this.lamda = lamda; }
    public double getLamda(){ return lamda; }
}
