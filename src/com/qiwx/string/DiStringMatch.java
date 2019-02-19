package com.qiwx.string;

import java.util.LinkedList;

//增减字符串匹配
public class DiStringMatch {
    public static void main(String[] args) {
        diStringMatch("IDID");
        diStringMatch("III");
        diStringMatch("DDI");
    }
    public static int[] diStringMatch(String S) {
        char[] chars=S.toCharArray();
        int len=chars.length;
        int[] result=new int[len+1];
        LinkedList<Integer> data=new LinkedList<>();
        for(int i=0;i<len+1;i++){
            data.add(i);
        }
        for(int i=0;i<len;i++){
            if(chars[i]=='I'){
                result[i]=data.pop();
            }else{
                result[i]=data.pollLast();
            }
        }
        result[len]=data.pop();
        return result;

    }
}
