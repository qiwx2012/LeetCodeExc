package com.qiwx.string;

import java.util.LinkedList;
import java.util.Stack;

//字符串相加
public class AddStrings {
    public static void main(String[] args) {
      System.out.println(addStrings("123","77799"));
    }
    public static String addStrings(String num1, String num2) {
        StringBuilder sb=new StringBuilder();
        //利用一个栈存储两个数据组
        LinkedList<Integer> stack=new LinkedList<>();
        if(num1.length()>num2.length()){
            String temp=num1;
            num1=num2;
            num2=temp;
        }
        int flag1=0;
        for(char c:num1.toCharArray()){
            stack.add(0,c-'0');
            flag1++;
            //stack1.addFirst(Character.digit(c,10));
        }
        for(char c:num2.toCharArray()){
            stack.add(stack.size(),c-'0');
            //stack2.addFirst(Character.digit(c,10));
        }
        int carray=0;
        int n1=0;
        int n2=0;
        int num=0;
        while (!stack.isEmpty()){
             n1=0;
             n2=0;
             if(flag1>0){
                n1= stack.pollFirst();
                flag1--;
             }
             n2= stack.pollLast();
             num=0;
            if(n1!=0){
                num+=n1;
            }
            if(n2!=0){
                num+=n2;
            }
            if(carray==1){
                num+=carray;
                carray=0;
            }
            if(num>9){
                carray=1;
            }
            sb.insert(0,num%10);
        }
        if(carray==1){
           sb.insert(0,1);
        }
         return sb.toString();
    }
}
