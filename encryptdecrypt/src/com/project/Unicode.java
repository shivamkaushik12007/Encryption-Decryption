package com.project;

public class Unicode implements Algorithm{
    public String encrypt(String str,int k){
        int n=str.length();
        String res=new String("");
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            int asc=(int)ch+k;
            ch=(char)asc;
            res+=Character.toString(ch);
        }
        return res;
    }
    public String decrypt(String str,int k){
        int n=str.length();
        String res=new String("");
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            int asc=(int)ch-k;
            ch=(char)asc;
            res+=Character.toString(ch);
        }
        return res;
    }
}
