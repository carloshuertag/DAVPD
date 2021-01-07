public class Davpd {
    private String name, description, function, cumulative, mean, variance;
    private double var, value, cumulativeValue, meanValue, varianceValue;
    public Davpd() {}
    public Davpd (String name, String description, String function, String cumulative, String mean, String variance) {
        this.name = name;
        this.description = description;
        this.function = function;
        this.cumulative = cumulative;
        this.mean = mean;
        this.variance = variance;
    }
    public void setName(String name){ this.name = name; }
    public String getName(){ return name; }
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
    public void setVar(double var){ this.var = var; }
    public double getVar(){ return var; }
    public void setValue(double value){ this.value = value; }
    public double getValue(){ return value; }
    public void setCumulativeValue(double cumulativeValue){ this.cumulativeValue = cumulativeValue; }
    public double getCumulativeValue(){ return cumulativeValue; }
    public void setMeanValue(double meanValue){ this.meanValue = meanValue; }
    public double getMeanValue(){ return meanValue; }
    public void setVarianceValue(double varianceValue){ this.varianceValue = varianceValue; }
    public double getVarianceValue(){ return varianceValue; }
    @Override
    public String toString() { return String.format("X ~ %s(X)", name); }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Davpd){
            Davpd davpd = (Davpd) obj;
            if(davpd.name == name)
                return true;
        }
        return false;
    }
}