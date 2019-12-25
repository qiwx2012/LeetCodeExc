package com.qiwx.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//相对名次
public class FindRelativeRanks {
    public static void main(String[] args) {

    }

    public static String[] findRelativeRanks(int[] nums) {
        int len = nums.length;
        String[] result = new String[len];
        int[] temp;
        temp = Arrays.copyOf(nums, len);
        Arrays.sort(temp);
        Map<Integer, String> maps = new HashMap<>();
        String t1 = "";
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                t1 = "Gold Medal";
            } else if (i == len - 2) {
                t1 = "Silver Medal";
            } else if (i == len - 3) {
                t1 = "Bronze Medal";
            } else {
                t1 = "" + (len - i);
            }
            maps.put(temp[i], t1);
        }
        for (int i = 0; i < len; i++) {
            result[i] = maps.get(nums[i]);
        }
        return result;
    }

}
