package com.qiwx.array;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//加1
public class PlusOne {
    public static void main(String[] args) {
      plusOne(new int[]{9});
      //plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});
    }
    public static int[] plusOne(int[] digits) {
        int len=digits.length;
        int num=0;
        int carry=0;//进位
        if(digits[len-1]+1>=10){
            carry=1;
        }else {
            digits[len-1]=digits[len-1]+1;
        }
        for(int i=len-1;i>=0;i--){
            if(digits[i]+carry>=10){
                digits[i]=0;
                carry=1;
            }else{
                digits[i]=digits[i]+carry;
                carry=0;
            }
        }
        int[] result=null;
        if(carry>0){
          result=new int[digits.length+1];
          result[0]=1;
          for(int i=1;i<result.length;i++){
              result[i]=digits[i-1];
          }
        }else{
            result=digits;
        }

       return result;

    }
}
