package com.qiwx.array;

import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{3, 3}));

    }

    private static boolean containsDuplicate(int[] nums) {
        if (nums == null)
            return false;
        int len = nums.length;
        if (len <= 1)
            return false;
        HashSet<Integer> maps = new HashSet<>();
        for (int i = 1; i < len; i++) {
            if (!maps.contains(nums[i])) {
                maps.add(nums[i]);
            } else {
                return false;
            }
        }
        return false;
    }

    //此方法跟节省时间
    private static boolean containDulicate2(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return false;
        int num = nums[0];
        HashSet<Integer> maps = new HashSet<>();
        for (int i = 0; i < len; i++) {
            maps.add(nums[i]);
        }
        return maps.size() != len;
    }
}
