package com.qiwx.array;

//287. 寻找重复数
public class FindDuplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    public static int findDuplicate(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        for (int i = 0; i < len; i++) {
            if (temp[nums[i] - 1] == 0) {
                temp[nums[i] - 1] = nums[i];
            } else {
                return nums[i];
            }
        }
        return 0;


    }
}
