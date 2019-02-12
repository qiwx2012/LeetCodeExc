package com.qiwx.array;

import java.util.Arrays;

//错误的集合
public class FindErrorNums {
    public static void main(String[] args) {
        //findErrorNums(new int[]{1,2,3,4,5,6,7,8,9,2});
        findErrorNums(new int[]{1,2,2,4});
        findErrorNums(new int[]{3,2,2});
    }
    private static int[] findErrorNums(int[] nums){
        int[] result=new int[2];
        int len=nums.length;
        Arrays.sort(nums);
        for(int i=1;i<len;i++){
            //找出缺少的数字
            //如果被复制的数比重复数大，那么符合下面的情况
            if(nums[i]==nums[i-1]){
                result[0]=nums[i];
                break;
            }
        }
        boolean sameIndex;
        if(nums[0]!=1){
            result[1]=1;
        }
        for(int i=1;i<len;i++){
            if(nums[i]-nums[i-1]==2){
                result[1]=nums[i]-1;
            }
        }
        if(result[1]==0){
            result[1]=len;
        }
        return result;
    }
}
