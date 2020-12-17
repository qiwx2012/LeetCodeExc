package com.qiwx.string;

import java.util.Collections;

public class ReverseWords {

    public static void main(String[] args) {
        //System.out.println(reverseWords("hello world   ni hao "));
        //System.out.println(reverseWords1(" hello world!  "));
        //System.out.println(reverseWords1("the sky is blue"));
        System.out.println(reverseWords1(" 1"));

    }
    public static String reverseWords(String s){
        String[] strings=s.split(" ");
        StringBuffer sb=new StringBuffer();
        for(int i=strings.length-1;i>=0;i--){
            if(strings[i].trim().length()>0){
                if(sb.length()!=0){
                   sb.append(" ");
                }
                sb.append(strings[i]);
            }
        }
//        sb.append("-");
        return sb.toString();

    }
    //
    public static String reverseWords1(String s){
//        if(s.replaceAll(" ","").length()==0)
//            return "";
//        if(s.replaceAll(" ","").length()==1)
//            return s.replaceAll(" ","");
        StringBuffer sb=new StringBuffer();
        int len=s.length();
        int index=-1;
        int count=1;
        boolean isStart=false;
        for(int i=0;i<len;i++){
            if(!isStart&&s.charAt(i)==' ')
                continue;
            if(!isStart&&s.charAt(i)!=' '){
                isStart=true;
                index=i;
                continue;
            }
            if(isStart&&s.charAt(i)!=' '){
                count++;
            }else {
                sb.insert(0,s.substring(index,index+count));
                sb.insert(0," ");
                isStart=false;
                count=1;
            }
        }
        if(isStart){
            sb.insert(0,s.substring(index,index+count));
            return sb.toString();
        }else {
            if(sb.length()>0)
                return sb.delete(0,1).toString();
            else
                return "";
        }

    }
}
