package com.qiwx.string;

import java.util.LinkedList;
import java.util.Stack;

//分数加减运算
public class FractionAddition {
    public static void main(String[] args) {
        System.out.println(fractionAddition2("1/3-1/2"));
        System.out.println(fractionAddition2("-1/2+1/2+1/3"));
        System.out.println(fractionAddition2("-1/2+1/2"));

     System.out.println(fractionAddition1("5/9+1/1+10/9"));
     System.out.println(fractionAddition("-1/2+1/2+1/3"));

     System.out.println(fractionAddition("5/3+1/3"));
    }
    public static String fractionAddition(String expression) {
        LinkedList<String> nums=new LinkedList<>();
        int len=expression.length();
        int fromIndex=0;
        int left;//分隔符左边索引
        int right;//分隔符右边索引
        int splitIndex=0;//分隔符位置；
        splitIndex=expression.indexOf("/",fromIndex);
        while (splitIndex>0){
            left=splitIndex-1;
            right=splitIndex+1;
            boolean leftEnd=false;
            boolean rightEnd=false;
            while (true){
                char leftc=expression.charAt(left);
                char rightc=expression.charAt(right);
                if((leftc>='0'&&leftc<='9')&&left>0){
                    left--;
                }else {
                    leftEnd=true;
                }
                if((rightc>='0'&&rightc<='9')&&right<len-1){
                    right++;
                }else {
                    rightEnd=true;
                }
                if(leftEnd&&rightEnd){
                    if(leftc=='+'){
                        left++;
                    }
                    if(rightc=='+'||rightc=='-'){
                        right--;
                    }
                    nums.add(expression.substring(left,right+1));
                    fromIndex=right;
                    break;
                }
            }
            splitIndex=expression.indexOf("/",fromIndex);
        }
        for(int i=1;i<=nums.size()-1;i++){
            String[] s1=nums.get(i-1).split("/");
            String[] s2=nums.get(i).split("/");
            int a1=Integer.parseInt(s1[0]);
            int b1=Integer.parseInt(s1[1]);
            int a2=Integer.parseInt(s2[0]);
            int b2=Integer.parseInt(s2[1]);
            if(b1==b2){
                a2=a1+a2;
            }else {
                a2=a1*b2+a2*b1;
                b2=b1*b2;
            }
            if(a2==0){
                nums.set(i,"0/1");
            }else {
                if(a2%b2==0){
                    nums.set(i,a2/b2+"/"+"1");
                }else {
                    //只需要计算最小数的一半就可以遍历完公约数
                    int size=Math.min(Math.abs(a2),Math.abs(b2))/2;
                    for(int j=2;j<size;j++){
                        if(a2%j==0&&b2%j==0){
                            a2=a2/j;
                            b2=b2/j;
                            j--;
                        }
                    }
                    nums.set(i,a2+"/"+b2);
                }
            }
        }
        return nums.getLast();
    }
    public static String fractionAddition1(String expression) {
        LinkedList<String> nums=new LinkedList<>();
        char[]chars=expression.toCharArray();
        int len=chars.length;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<len;i++){
           if(sb.length()!=0&&(chars[i]=='+'||chars[i]=='-')){
               nums.add(sb.toString());
               sb.delete(0,sb.length());
               if(chars[i]=='-'){
                   sb.append(chars[i]);
               }
            }else {
               if(chars[i]!='+'){
                   sb.append(chars[i]);
               }
           }
        }
        if(sb.length()>0)
            nums.add(sb.toString());
        for(int i=1;i<=nums.size()-1;i++){
            String[] s1=nums.get(i-1).split("/");
            String[] s2=nums.get(i).split("/");
            int a1=Integer.parseInt(s1[0]);
            int b1=Integer.parseInt(s1[1]);
            int a2=Integer.parseInt(s2[0]);
            int b2=Integer.parseInt(s2[1]);
            if(b1==b2){
                a2=a1+a2;
            }else {
                a2=a1*b2+a2*b1;
                b2=b1*b2;
            }
            if(a2==0){
                nums.set(i,"0/1");
            }else {
                if(a2%b2==0){
                    nums.set(i,a2/b2+"/"+"1");
                }else {
                    //只需要计算最小数的一半就可以遍历完公约数
                    int size=Math.min(Math.abs(a2),Math.abs(b2))/2;
                    for(int j=2;j<size;j++){
                        if(a2%j==0&&b2%j==0){
                            a2=a2/j;
                            b2=b2/j;
                            j--;
                        }
                    }
                    nums.set(i,a2+"/"+b2);
                }
            }
        }
        return nums.getLast();
    }
    public static String fractionAddition2(String expression) {
        LinkedList<String> nums=new LinkedList<>();
        int len=expression.length();
        int start=0;
        for(int i=0;i<len;i++){
            char c=expression.charAt(i);
            if(i>start&&(c=='+'||c=='-')){
                nums.add(expression.substring(start,i));
                if(c=='+'){
                    start=i+1;
                }else {
                    start=i;
                }

            }else {

            }
        }
        if(start<len)
            nums.add(expression.substring(start,len));
        for(int i=1;i<=nums.size()-1;i++){
            String[] s1=nums.get(i-1).split("/");
            String[] s2=nums.get(i).split("/");
            int a1=Integer.parseInt(s1[0]);
            int b1=Integer.parseInt(s1[1]);
            int a2=Integer.parseInt(s2[0]);
            int b2=Integer.parseInt(s2[1]);
            if(b1==b2){
                a2=a1+a2;
            }else {
                a2=a1*b2+a2*b1;
                b2=b1*b2;
            }
            if(a2==0){
                nums.set(i,"0/1");
            }else {
                if(a2%b2==0){
                    nums.set(i,a2/b2+"/"+"1");
                }else {
                    //只需要计算最小数的一半就可以遍历完公约数
                    int size=Math.min(Math.abs(a2),Math.abs(b2))/2;
                    for(int j=2;j<size;j++){
                        if(a2%j==0&&b2%j==0){
                            a2=a2/j;
                            b2=b2/j;
                            j--;
                        }
                    }
                    nums.set(i,a2+"/"+b2);
                }
            }
        }
        return nums.getLast();
    }
}
