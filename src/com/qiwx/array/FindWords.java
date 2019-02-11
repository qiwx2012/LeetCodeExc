package com.qiwx.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindWords {
    public static void main(String[] args) {

    }
    private static String[] findWords(String[] words){
        Map<Character,Integer> maps=new HashMap<>();
        String s1="qwertyuiop";
        String s2="asdfghjkl";
        String s3="zxcvbnm";
        for (char c:s1.toCharArray()
             ) {
            maps.put(c,1);
        }
        for (char c:s2.toCharArray()
        ) {
            maps.put(c,2);
        }
        for (char c:s3.toCharArray()
        ) {
            maps.put(c,3);
        }
        int len=words.length;
        List<String> list=new LinkedList<>();
        for(int i=0;i<len;i++){
            boolean isSame=true;

            for(int j=1;j<words[i].length();j++){
                   if(maps.get(Character.toLowerCase(words[i].charAt(j)))!=maps.get(Character.toLowerCase(words[i].charAt(j-1)))){
                       isSame=false;
                       break;
                   }
                }
            if(isSame){
                list.add(words[i]);
            }

        }
        int len1=list.size();
        return list.toArray(new String[len1]);


    }

}
