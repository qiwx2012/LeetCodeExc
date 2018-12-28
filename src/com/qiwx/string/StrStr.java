package com.qiwx.string;
//实现strstr
public class StrStr {
    public static void main(String[] args) {
      System.out.println(strStr("aaaa","bba"));
      System.out.println(strStr("hello","ll"));
      System.out.println(strStr("aab","aac"));

        System.out.println(strStr("mississippi","issip"));
    }

    public static int strStr(String haystack, String needle) {
        if(needle==null||needle.length()==0)
            return 0;
        int i;
        int j;
        int len=needle.length();
        for(i=0,j=0;j<haystack.length();){
            char end=haystack.charAt(j);
            if(j-i<len){
                if(end==needle.charAt(j-i)){
                    j++;
                }else{
                    i++;
                    j=i;
                }
            }else{
                break;
            }


        }
        if(j-i==needle.length()){
            return i;
        }else{
            return -1;
        }

    }
}
