public final class Encrypt{
    private static char ToChar(int i){
        return (char)((int)'A'+i-(int)('0'));
    }
    private static char ToInt(char i){
        return (char)((int)i-(int)'A'+(int)('0'));
    }
    public static String encrypt(String x){
        int in=0;
        while(x.charAt(in)!='/')in++;
        if(x.charAt(in)=='/') in++;
        String ans = "";
        int dot=0;
        while(in<x.length()){
            if(x.charAt(in)!='.')ans += ToChar((int)x.charAt(in));
            else{
                ans += (char)(dot+(int)('0'));  
                dot++;
            } 
            in++;
        }
        return ans;
    }
    public static String decrypt(String x){
        String ans = "";
        int in = 0;
        while(in<x.length()){
            if((int)x.charAt(in) <=(int)'9' &&  (int)'0'<=(int)x.charAt(in)){
                ans+=".";
            } else{
                ans+=ToInt(x.charAt(in));
            }
            in++;
        }
        return ans;
    }
}