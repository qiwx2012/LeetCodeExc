package com.qiwx.array;

/**
 * @description
 * @Author qiwx
 * @Date 2020-12-16 16:32
 * 找出未排序数组中最大值和最小值
 **/
public class FindMax2MinNumber {
    public static void main(String[] args) {
        int[] result = findMax2MinNumber(new int[]{35, 5, 6, -2, 98,1});
        System.out.println(result[0] + "," + result[1]);
    }

    private static int[] findMax2MinNumber(int[] nums) {
        int min, max;
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            result[0] = 0;
            result[1] = 0;
        }
        if (nums.length == 1) {
            result[0] = nums[0];
            result[1] = nums[0];
        }
        min = nums[0];
        max = nums[1];
        if (min > max) {
            min = min ^ max;
            max = min ^ max;
            min = min ^ max;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if (nums[i] < min) {
                min = nums[i];
            }
        }
        result = new int[]{min, max};

        return result;
    }

}
