public class User {
    private String name, ip;
    public User() { }
    public void setName(String name) { this.name = name; }
    public String getName () { return name; }
    public void setIp(String ip) { this.ip = ip; }
    public String getIp () { return ip; }
    @Override
    public String toString(){ return String.format("%s (%s)", name, ip); }
}
