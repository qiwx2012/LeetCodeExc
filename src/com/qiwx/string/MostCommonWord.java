package com.qiwx.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//最常见的单词
public class MostCommonWord {
    public static void main(String[] args) {
      // System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",new String[]{"hit"}));
       System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c?",new String[]{"a"}));
    }
    public static String mostCommonWord(String paragraph, String[] banned) {
        String result="";
        int value=-1;
        String[] strs=paragraph.toLowerCase().split(" |,|\\?|'|;|\\.|!");
        Set<String> banSet=new HashSet<>();
        banSet.add("");
        for(int i=0;i<banned.length;i++){
            banSet.add(banned[i]);
        }
        Map<String,Integer> maps=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            if(banSet.contains(strs[i]))
                continue;
            if(maps.containsKey(strs[i])){
                maps.put(strs[i],maps.get(strs[i])+1);
            }else{
                maps.put(strs[i],1);
            }
            if(value<maps.get(strs[i])){
                result=strs[i];
                value=maps.get(strs[i]);
            }
        }
        return result;
    }
}
