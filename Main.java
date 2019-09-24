package encryptdecrypt;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main{
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String func="enc";
        String str="";
        String out="";
        String algo="unicode";
        int k=Integer.MIN_VALUE;
        for(int i=0;i<args.length;i++){
            if(i<args.length-1&&args[i].equals("-mode")&&!args[i+1].equals("-alg")&&!args[i+1].equals("-out")&&!args[i+1].equals("-in")&&!args[i+1].equals("-data")&&!args[i+1].equals("-key")){
                func=args[i+1];
            }else if(i<args.length-1&&args[i].equals("-data")&&!args[i+1].equals("-alg")&&!args[i+1].equals("-out")&&!args[i+1].equals("-in")&&!args[i+1].equals("-key")&&!args[i+1].equals("-mode")){
                str=args[i+1];
            }else if(i<args.length-1&&args[i].equals("-key")&&!args[i+1].equals("-alg")&&!args[i+1].equals("-out")&&!args[i+1].equals("-in")&&!args[i+1].equals("-data")&&!args[i+1].equals("-mode")){
                k=Integer.parseInt(args[i+1]);
            }else if(i<args.length-1&&args[i].equals("-in")&&!args[i+1].equals("-alg")&&!args[i+1].equals("-out")&&!args[i+1].equals("-key")&&!args[i+1].equals("-data")&&!args[i+1].equals("-mode")){
                try{
                    File file = new File(args[i+1]);
                    Scanner sc=new Scanner(file);
                    str=sc.nextLine();
                    sc.close();
                }catch(Exception e){
                    System.out.println(e.getMessage());
                    return;
                }
            }else if(i<args.length-1&&args[i].equals("-out")&&!args[i+1].equals("-alg")&&!args[i+1].equals("-data")&&!args[i+1].equals("-in")&&!args[i+1].equals("-data")&&!args[i+1].equals("-mode")){
                out=args[i+1];
            }else if(i<args.length-1&&args[i].equals("-alg")&&!args[i+1].equals("-out")&&!args[i+1].equals("-data")&&!args[i+1].equals("-in")&&!args[i+1].equals("-data")&&!args[i+1].equals("-mode")){
                algo=args[i+1];
            }
        }
        if(str.equals("")){
            str=scanner.nextLine();
        }
        if(k==Integer.MIN_VALUE) {
            k=scanner.nextInt();
        }
        func=func.toLowerCase();
        if(func.equals("enc")){
            if(algo.equals("unicode")){
                Unicode un=new Unicode();
                str=un.encrypt(str,k);
            }else if(algo.equals("shift")){
                Shift sf=new Shift();
                str=sf.encrypt(str,k);
            }

        }else if(func.equals("dec")){
            if(algo.equals("unicode")){
                Unicode un=new Unicode();
                str=un.decrypt(str,k);
            }else if(algo.equals("shift")){
                Shift sf=new Shift();
                str=sf.decrypt(str,k);
            }
        }
        if(out.equals("")){
            System.out.println(str);
        }else{
            try {
                File file = new File(out);
                FileWriter writer = new FileWriter(file);
                writer.write(str);
                writer.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}