package com.qiwx.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//赎金信
public class CanConstruct {
    public static void main(String[] args) {
        canConstruct2("aa","aab");
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
            int len=ransomNote.length();
            String[] strs=ransomNote.split("");
             for(int i=0;i<len;i++){
                 if(magazine.indexOf(strs[i])>=0){
                     magazine= magazine.replaceFirst(strs[i],"");
                 }else{
                     return false;
                 }
             }
              return true;
    }
    public static boolean canConstruct1(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();
        int len=magazine.length();
        char[] chars=magazine.toCharArray();
        for(int i=0;i<len;i++){
            char key=chars[i];
            map.put(key,map.getOrDefault(key,0)+1);
        }
        int len1=ransomNote.length();
        char[] chars1=ransomNote.toCharArray();
        for(int i=0;i<len1;i++){
            char key=chars1[i];
            if(map.getOrDefault(key,0)<=0){
                return false;
            }else{
                map.put(key,map.get(key)-1);
            }
        }
        return true;
    }
    public static boolean canConstruct2(String ransomNote, String magazine) {
        Map<String,Integer> map=new HashMap<>();
        int len=ransomNote.length();
        String[] strs=ransomNote.split("");
        for(int i=0;i<len;i++){
            int index=map.getOrDefault(strs[i],0);
            int pos=magazine.indexOf(strs[i],index);
            if(pos>=0){
                map.put(strs[i],pos+1);
            }else{
                return false;
            }
        }

        return true;
    }
    private boolean a(String ransomNote, String magazine){
        if (ransomNote.length() == 0 && magazine.length() == 0) return true;
        if (ransomNote == null && magazine == null) return true;
        if (magazine == null || magazine.length() == 0) return false;
        char[] chars0 = ransomNote.toCharArray();
        char[] chars1 = magazine.toCharArray();
        Arrays.sort(chars0);
        Arrays.sort(chars1);
        int j = 0;
        int i = 0;
        while ( i < chars0.length ) {
            if (j >= chars1.length) return false;
            if (chars0[i] == chars1[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return true;
    }
}
