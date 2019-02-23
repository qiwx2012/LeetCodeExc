package com.qiwx.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//两句话中的不常见单词
public class UncommonFromSentences {
    public static void main(String[] args) {
        uncommonFromSentences("this apple is sweet","this apple is sour");
    }
    public static String[] uncommonFromSentences(String A, String B) {

         List<String> lists=new LinkedList<>();
         String[] a=A.split(" ");
         String[] b=B.split(" ");
         Map<String,Boolean> maps=new HashMap<>();
         //根据题意只需要记载出现一次的单词
         for(String s:a){
             if(maps.containsKey(s)){
                 //mapsA.put(s,mapsA.getOrDefault(s,0)+1);
                 //不需要计算具体数字，只需要记载真假
                 maps.put(s,false);
             }else {
                 maps.put(s,true);
             }
         }
        for(String s:b){
            if(maps.containsKey(s)){
                maps.put(s,false);
            }else {
                maps.put(s,true);
            }
        }

        //检查map中符合条件
        for(String key:maps.keySet()){
            if(maps.get(key)){
                lists.add(key);
            }
        }
        return lists.toArray(new String[lists.size()]);
    }
}
