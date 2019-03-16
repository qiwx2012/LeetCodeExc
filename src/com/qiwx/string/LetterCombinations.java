package com.qiwx.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//电话号码的字母组合
public class LetterCombinations {
    public static void main(String[] args) {
      //letterCombinations("7");
      letterCombinations("23");
    }
    public  static List<String> letterCombinations(String digits) {
        Map<Character,String> maps=new HashMap<>();
        maps.put('2',"abc");
        maps.put('3',"def");
        maps.put('4',"ghi");
        maps.put('5',"jkl");
        maps.put('6',"mno");
        maps.put('7',"pqrs");
        maps.put('8',"tuv");
        maps.put('9',"wxyz");
        LinkedList<String> result=new LinkedList<>();
        for(int i=0;i<digits.length();i++){
            String [] temp=maps.get(digits.charAt(i)).split("");
            if(result.size()==0){
                for(String s:temp){
                    result.add(s);
                }
            }else {
                int size=result.size();
                StringBuffer sb=new StringBuffer();
                for(int j=0;j<size;j++){
                    sb.delete(0,sb.length());
                    sb.append(result.pop());
                   for(int k=0;k<temp.length;k++){
                        sb.append(temp[k]);
                        result.addLast(sb.toString());
                        sb.delete(sb.length()-1,sb.length());
                   }
                }

            }

        }
        return result;

    }
}
