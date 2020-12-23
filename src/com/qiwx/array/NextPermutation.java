package com.qiwx.array;

/**
 * @description
 * @Author qiwx
 * @Date 2020-12-21 14:08
 * 下一个排列
 **/
public class NextPermutation {
    public static void main(String[] args) {

        nextPermutation(new int[]{3, 2, 1});
        nextPermutation(new int[]{1});
        nextPermutation(new int[]{1, 4});
        nextPermutation(new int[]{4, 2});
        nextPermutation(new int[]{1, 1, 5});

    }

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }

            nums[i]=nums[i]^nums[j];
            nums[j]=nums[i]^nums[j];
            nums[i]=nums[i]^nums[j];
        }

        int left = i+1, right = nums.length - 1;
        while (left < right) {
            nums[left]=nums[left]^nums[right];
            nums[right]=nums[left]^nums[right];
            nums[left]=nums[left]^nums[right];
            left++;
            right--;
        }

    }
}
