package com.qiwx.array;
//子数组最大平均数
public class FindMaxAverage {
    public static void main(String[] args) {
       System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
       System.out.println(findMaxAverage(new int[]{5},1));
       System.out.println(findMaxAverage(new int[]{-1},1));
    }
    public static double findMaxAverage(int[] nums, int k) {
        int sum=0;
        int maxSum=0;
        //前k个元素和
        for(int i=0;i<k;i++){
            maxSum+=nums[i];
        }
        sum=maxSum;
        for(int i=k;i<nums.length;i++){
            sum-=nums[i-k];//去掉首位
            sum+=nums[i];//添加末位
            if(maxSum<sum){
                maxSum=sum;
            }
        }
        return ((double) maxSum)/k;
    }
}
