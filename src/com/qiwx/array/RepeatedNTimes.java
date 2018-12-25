package com.qiwx.array;

import java.util.HashSet;
import java.util.Set;

//重复 N 次的元素
public class RepeatedNTimes {
    public static void main(String[] args) {
           System.out.println(repeatedNTimes(new int[]{2,1,2,5,3,2}));

    }
    public static int repeatedNTimes(int[] A) {
        int len=A.length/2+2;//查找数组长度的1/2+1次
        Set<Integer> sets=new HashSet<Integer>();
        int num=0;
        for(int i=0;i<len;i++){
            if(!sets.contains(A[i])){
                sets.add(A[i]);
            }else{
                num=A[i];
                break;
            }

          }
          return num;
    }
}
