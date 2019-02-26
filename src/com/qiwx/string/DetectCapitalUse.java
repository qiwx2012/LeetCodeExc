package com.qiwx.string;

import java.util.HashMap;
import java.util.Map;

//检测大写字母
public class DetectCapitalUse {
    public static void main(String[] args) {
       System.out.println(detectCapitalUse("FlaG"));
       System.out.println(detectCapitalUse("Leetcode"));
       System.out.println(detectCapitalUse("mL"));
    }
    public static boolean detectCapitalUse(String word) {
        if(word.length()==1)
            return true;
        boolean isFirstCase=false;
        if(word.charAt(0)>='A'&&word.charAt(0)<='Z'){
            isFirstCase=true;
        }else {
            isFirstCase=false;
        }
        boolean isBig=true;
        Map<Character,Boolean> maps=new HashMap<>();
        String ss="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for(char c:ss.toCharArray()){
            maps.put(c,true);
        }
        for(int i=1;i<word.length();i++){
            //如果第一个是小写，那么剩下的都必须是小写，
            //如果有大写直接返回false
            char c=word.charAt(i);
            if(!isFirstCase){
                if(maps.getOrDefault(c,false)){
                    return false;
                }
            }else {
                if(i==1){
                    if(maps.getOrDefault(c,false)){
                        isBig=true;
                    }else {
                        isBig=false;
                    }
                }else {
                    if(maps.getOrDefault(c,false)){
                        if(!isBig){
                           return false;
                        }

                    }else {
                        if(isBig){
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }
}
