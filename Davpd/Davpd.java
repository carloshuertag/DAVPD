import java.io.Serializable;

public abstract class Davpd{
    protected  String description, functions;
    protected transient double value, cumulativeValue, meanValue, varianceValue;
    protected transient int var;
    public Davpd() {}
    public Davpd (String description, String functions) {
        this.description = description;
        this.functions = functions;
    }
    public void setDescription(String description){ this.description = description; }
    public String getDescription(){ return description; }
    public void setFunctions(String functions){ this.functions = functions; }
    public String getFunctions(){ return functions; }
    public void setVar(int var){ this.var = var; }
    public int getVar() { return var; }
    public abstract double getValue();
    public abstract double getCumulativeValue();
    public abstract double getMeanValue();
    public abstract double getVarianceValue();
}
