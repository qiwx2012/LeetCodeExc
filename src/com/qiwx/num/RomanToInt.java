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
    public static int romanToInt1(String s) {
        //空字符串
        if(null==s||s.length()==0){
            return 0;
        }
        char[] str=s.toCharArray();
        int len=str.length;
        int num=0;
        for(int i=0;i<len;i++){
            if(i<len-1){
                //如果左边比右边小，说明是特殊情况，前面大数要减去
                int temp=getNum(str[i+1])-getNum(str[i]);
                if(temp>0){
                    num+=temp;
                    i++;
                }else {
                    num+=getNum(str[i]);
                }
            }else {
                num+=getNum(str[i]);
            }
        }

        return num;
    }
    private static int getNum(char key){
        switch (key){
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

}
