import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -8325470871823271412L;
    private String name, ip;
    public User() { }
    public User(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }
    public void setName(String name) { this.name = name; }
    public String getName () { return name; }
    public void setIp(String ip) { this.ip = ip; }
    public String getIp () { return ip; }
    @Override
    public String toString(){ return String.format("%s (%s)", name, ip); }
}
