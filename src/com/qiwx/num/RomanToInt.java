package com.qiwx.num;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("III"));

    }
    public static int romanToInt(String s) {
        Map<Character,Integer> romanMap=new HashMap<Character,Integer>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        //空字符串
        if(null==s||s.length()==0){
            return 0;
        }
        char[] str=s.toCharArray();
        int len=str.length;
        int num=0;
        //只有一个字符串
        if(len==1){
            return romanMap.get(str[0]);
        }
        for(int i=0;i<len;i++){
            if(i>=len-1){
                num+=romanMap.get(str[i]);
            }else{
                if(romanMap.get(str[i])>=romanMap.get(str[i+1])){
                   num+=romanMap.get(str[i]);
                }else{
                    num+=(romanMap.get(str[i+1])-romanMap.get(str[i]));
                    i++;
                }

            }

        }
        return num;

    }
}
