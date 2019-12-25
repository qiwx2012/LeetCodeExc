package com.qiwx.array;

import java.util.Arrays;

//数组拆分 I
public class ArrayPairSum {
    public static void main(String[] args) {

    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i += 2) {
            count += nums[i];
        }
        return count;

    }

}
