package encryptdecrypt;

public class Shift implements Algorithm{
    public static String ac="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String bc="abcdefghijklmnopqrstuvwxyz";
    public  String encrypt(String str,int k){
        int n=str.length();
        String res=new String("");
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(ac.contains(Character.toString(ch))){
                int num=ac.indexOf(Character.toString(ch));
                int rum=(num+k)%26;
                ch=ac.charAt(rum);
                res+=Character.toString(ch);
            }else if(bc.contains(Character.toString(ch))) {
                int num=bc.indexOf(Character.toString(ch));
                int rum=(num+k)%26;
                ch=bc.charAt(rum);
                res+=Character.toString(ch);
            }else{
                res+=Character.toString(ch);
            }
        }
        return res;
    }
    public String decrypt(String str,int k){
        int n=str.length();
        String res=new String("");
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(ac.contains(Character.toString(ch))){
                int num=ac.indexOf(Character.toString(ch));
                int rum=(num-k)%26;
                rum=rum<0?rum+26:rum;
                ch=ac.charAt(rum);
                res+=Character.toString(ch);
            }else if(bc.contains(Character.toString(ch))) {
                int num=bc.indexOf(Character.toString(ch));
                int rum=(num-k)%26;
                rum=rum<0?rum+26:rum;
                ch=bc.charAt(rum);
                res+=Character.toString(ch);
            }else{
                res+=Character.toString(ch);
            }
        }
        return res;
    }
}
