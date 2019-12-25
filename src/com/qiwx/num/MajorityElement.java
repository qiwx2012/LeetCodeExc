package com.qiwx.num;

import java.util.HashMap;
import java.util.Map;

//求众数
public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    private static int majorityElement1(int[] nums) {
        int result = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (0 == count) {
                count = 1;
                result = nums[i];
            } else if (nums[i] == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }

    private static int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        int majority = len / 2 + 1;
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!maps.containsKey(nums[i])) {
                maps.put(nums[i], 1);
            } else {
                int temp = maps.get(nums[i]) + 1;
                if (temp >= majority) {
                    return nums[i];
                } else {
                    maps.put(nums[i], temp);
                }
            }

        }
        return 0;

    }
}
