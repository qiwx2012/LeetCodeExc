package com.qiwx.array;

import java.util.HashSet;

//缺失的数字
public class MissingNumber {
    public static void main(String[] args) {
        missingNumber(new int[]{3,0,1});
    }
    //利用数学原理
    private static int missingNumber(int[] nums){
        int len=nums.length;
        //利用数学特性，先把1到n的和求出来，然后减去数组中的数，余数是多少
        //就是缺少的数
        int sum=len*(len+1)/2;
        for(int i=0;i<len;i++){
            sum-=nums[i];
        }
        return sum;

    }
    //利用计算机原理，异或操作，两个位数相同位0 不同为1
    //0与任何数异或都是原数
    private static int missingNumber1(int[] nums){
        int len=nums.length;
        int num=0;
        for(int i=0;i<len;i++){
          num=nums[i]^num^i;
        }
        //因为循环会漏掉最大值，所以最后要单独将最大值再次异或一次
        num=num^(len);
        return num;

    }
}
