package com.qiwx.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//报数
public class CountAndSay {
    public static void main(String[] args) {
    // System.out.println(countAndSay(1));
     System.out.println(countAndSay(4));
     System.out.println(countAndSay(5));
     System.out.println(countAndSay(6));
    }
    /*
    *报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。
    * 其前五项如下：
    * 1
    * 11
    * 21
    * 1211
    * 111221
    * 因为第一个描述为1个1所以第二个为11
    * 第二个描述是2个1所以第三个是21
    * 以此类推将描述所涉及到的数字组合成下一行显示的值
    * */
    public static String countAndSay1(int n) {
        //现将数字n转成字符串
        StringBuffer sb=new StringBuffer();
        Stack<Map<Character,Integer>> stacks=new Stack<>();
        sb.append("1");
        int count=0;
        while (n>1){
            count=0;
            for(int i=0;i<sb.length();i++) {
                if (stacks.isEmpty()) {
                    count++;
                    Map<Character,Integer> map=new HashMap<>();
                    map.put(sb.charAt(i),count);
                    stacks.push(map);
                } else {
                    if (stacks.peek().containsKey(sb.charAt(i))) {
                        Map<Character,Integer> map=stacks.peek();
                        count++;
                        map.put(sb.charAt(i),count);
                    } else {
                        count=1;
                        Map<Character,Integer> map=new HashMap<>();
                        map.put(sb.charAt(i),count);
                        stacks.push(map);
                    }
                }
            }
            sb.delete(0,sb.length());
            while (!stacks.isEmpty()){
                Map<Character,Integer>map=stacks.pop();
                map.forEach((k,v)->{
                    sb.insert(0,k);
                    sb.insert(0,v);
                });
            }
            n--;
        }
        return sb.toString();

    }
    public static String countAndSay(int n) {

        if(n==1){
            return "1";
        }
        StringBuffer sb=new StringBuffer();
        int count=0;
        char curkey;
        //递归返回字符串
        String origin = countAndSay(n-1);
        curkey=origin.charAt(0);
        for(int i=0;i<origin.length();i++) {
            char curr=origin.charAt(i);
            if (curkey == curr) {
                count++;
            } else {
                sb.append(count);
                sb.append(curkey);
                count = 1;
                curkey = curr;
            }
        }

        sb.append(count);
        sb.append(curkey);

      return sb.toString();

    }
}
