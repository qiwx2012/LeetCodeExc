package com.qiwx.array;
//最大子序号
public class MaxSubArray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }
    private static int maxSubArray(int[]nums){
        int res = nums[0];
        int sum = 0;//初始和为0
        for (int num : nums) {
            if (sum > 0)//当和大于0，继续往后加，如果和小于0直接舍弃
                sum += num;
            else
                sum = num;//如果之前的和小于0，就从当前数开始往后加
            res = Math.max(res, sum);
        }
        return res;
    }

}
