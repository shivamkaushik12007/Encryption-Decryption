import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String stringOne=scanner.nextLine();
        String stringTwo=scanner.nextLine();

        String[] arrayOne=stringOne.split("[^a-zA-Z]");
        String[] arrayTwo=stringTwo.split("[^a-zA-Z]");
        stringOne="";
        stringTwo="";

        for(int i=0;i<arrayOne.length;i++){
            stringOne+=arrayOne[i];
        }

        for(int i=0;i<arrayTwo.length;i++){
            stringTwo+=arrayTwo[i];
        }

        boolean isPalindrome=true;

        char[] charArrayOne=stringOne.toCharArray();
        char[] charArrayTwo=stringTwo.toCharArray();
        Arrays.sort(charArrayOne);
        Arrays.sort(charArrayTwo);

        if(stringOne.length()!=stringTwo.length()){
            System.out.println("Unequal Length");
        }else {
            for(int i=0;i<charArrayOne.length;i++){
                if(charArrayOne[i]!=charArrayTwo[i]){
                    isPalindrome=false;
                    System.out.println("Not a palindrome");
                    break;
                }
            }
            if(isPalindrome){
                System.out.println("Is a palindrome");
            }

        }
    }
}
