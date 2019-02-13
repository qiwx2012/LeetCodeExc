package com.qiwx.string;
//秘钥格式化
public class LicenseKeyFormatting {
    public static void main(String[] args) {
     System.out.println(licenseKeyFormatting("5F3Z-2e-9-w",4));
     System.out.println(licenseKeyFormatting("2-5g-3-J",2));
     System.out.println(licenseKeyFormatting("2-53-J",1));
    }
    public static String licenseKeyFormatting(String S, int K) {
       S=S.replaceAll("-","");
       int len=S.length();
       int first=len%K;
       StringBuffer sb=new StringBuffer();
       if(first>0){
           sb.append(S.substring(0,first).toUpperCase());
           if(first<len){
               sb.append('-');
           }
       }
       for(int i=first;i<len-K+1;i+=K){
           String temp=S.substring(i,i+K).toUpperCase();
           sb.append(temp);
           if(i<len-first-K){
               sb.append('-');
           }
       }
       return sb.toString();


    }
    //更快
    public String licenseKeyFormatting1(String S, int K) {
        S=S.replaceAll("-","");
        int len=S.length();
        int first=len%K;
        StringBuffer sb=new StringBuffer();
        if(first>0){
            for(int i=0;i<first;i++){
                char c=S.charAt(i);
                if(c>='a'&&c<='z'){
                    c=Character.toUpperCase(S.charAt(i));
                }
                sb.append(c);
            }
            if(first<len){
                sb.append('-');
            }

        }
        int index=0;
        for(int i=first;i<len;i++){
            index++;
            char c=S.charAt(i);
            if(c>='a'&&c<='z'){
                c=Character.toUpperCase(S.charAt(i));
            }
            sb.append(c);
            if(index==K&&i<len-1){
                sb.append('-');
                index=0;
            }
        }
        return sb.toString();
    }
}
