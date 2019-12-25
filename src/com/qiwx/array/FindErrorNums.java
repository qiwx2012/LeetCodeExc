package com.qiwx.array;

import java.util.Arrays;
import java.util.HashSet;

//错误的集合
public class FindErrorNums {
    public static void main(String[] args) {
        //findErrorNums(new int[]{1,2,3,4,5,6,7,8,9,2});
        // findErrorNums1(new int[]{1,2,2,4});
        findErrorNums1(new int[]{3, 2, 3, 4, 6, 5});
    }

    private static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 1; i < len; i++) {
            //找出缺少的数字
            //如果被复制的数比重复数大，那么符合下面的情况
            if (nums[i] == nums[i - 1]) {
                result[0] = nums[i];
                break;
            }
        }
        if (nums[0] != 1) {
            result[1] = 1;
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] - nums[i - 1] == 2) {
                result[1] = nums[i] - 1;
            }
        }
        if (result[1] == 0) {
            result[1] = len;
        }
        return result;
    }

    private static int[] findErrorNums1(int[] nums) {
        int[] result = new int[2];
        int len = nums.length;
        Arrays.sort(nums);
        HashSet<Integer> sets = new HashSet<>();
        for (int i = 0; i < len; i++) {
            sets.add(nums[i]);
        }
        int size = 0;
        if (!sets.contains(1)) {
            result[1] = 1;
            size++;
        } else if (!sets.contains(len)) {
            result[1] = len;
            size++;
        }
        for (int i = 1; i < len; i++) {
            if (result[0] == 0) {
                if (nums[i] == nums[i - 1]) {
                    result[0] = nums[i];
                    size++;
                    if (size == 2) {
                        break;
                    }
                }
            }
            if (result[1] == 0) {
                if (!sets.contains(i)) {
                    result[1] = i;
                    size++;
                    if (size == 2) {
                        break;
                    }
                }
            }
        }
        return result;
    }

}
