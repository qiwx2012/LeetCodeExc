package com.qiwx.array;

import java.util.Arrays;

//最接近三数字之和
public class ThreeSumClosest {
    public static void main(String[] args) {
        //System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
        System.out.println(threeSumClosest(new int[]{-3, -2, -5, -4, 3}, -1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int mostclosest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int temp = num + nums[start] + nums[end];
                if (temp == target) {
                    return temp;
                } else if (temp < target) {
                    start++;
                } else {
                    end--;
                }
                if (Math.abs(temp - target) < Math.abs(mostclosest - target)) {
                    mostclosest = temp;
                }
            }
        }

        return mostclosest;

    }

}
