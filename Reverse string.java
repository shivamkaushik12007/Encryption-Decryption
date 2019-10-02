import java.util.Scanner;

public class SwappingAndReversingString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        String[] arr=s.split(" ");
        String reverseString=arr[arr.length-1]+" ";
        String temp="";
        for(int i=1;i<arr.length-1;i++){
            temp+=" "+arr[i];
        }
        StringBuffer stringBuffer=new StringBuffer(temp);
        temp=stringBuffer.reverse().toString();
        reverseString=reverseString+temp+arr[0];
        System.out.println(reverseString);
    }
}
