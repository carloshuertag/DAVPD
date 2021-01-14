import java.io.Serializable;

public abstract class Davpd implements Serializable{
    private static final long serialVersionUID = 3370351772286807795L;
    protected  String description, function, cumulative, mean, variance;
    protected transient double value, cumulativeValue, meanValue, varianceValue;
    protected transient int var;
    public Davpd() {}
    public Davpd (String description, String function, String cumulative, String mean, String variance) {
        this.description = description;
        this.function = function;
        this.cumulative = cumulative;
        this.mean = mean;
        this.variance = variance;
    }
    public void setDescription(String description){ this.description = description; }
    public String getDescription(){ return description; }
    public void setFunction(String function){ this.function = function; }
    public String getFunction(){ return function; }
    public void setCummulative(String cumulative){ this.cumulative = cumulative; }
    public String getCumulative(){ return cumulative; }
    public void setMean(String mean){ this.mean = mean; }
    public String getMean(){ return mean; }
    public void setVariance(String variance){ this.variance = variance; }
    public String getVariance(){ return variance; }
    public void setVar(int var){ this.var = var; }
    public int getVar() { return var; }
    public abstract double getValue();
    public abstract double getCumulativeValue();
    public abstract double getMeanValue();
    public abstract double getVarianceValue();
}
