package com.qiwx.array;

import java.util.Arrays;
import java.util.LinkedList;

//缺失的第一个正数
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive1(new int[]{0, 2, 2, 1, 1}));
        System.out.println(firstMissingPositive1(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive1(new int[]{7, 8, 9, 11, 12}));
    }

    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> maps = new LinkedList<>();
        maps.push(1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (maps.peek() == nums[i] || maps.contains(nums[i])) {
                    maps.push(nums[i] + 1);
                } else {

                    return maps.poll();
                }
            }
        }
        return maps.poll();

    }

    public static int firstMissingPositive1(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                j = i + 1;
                for (; j < nums.length; j++) {
                    if (nums[j] == i + 1) {
//                        int a=nums[i];
//                        nums[i]=nums[j];
//                        nums[j]=a;
                        nums[i] = nums[i] ^ nums[j];
                        nums[j] = nums[i] ^ nums[j];
                        nums[i] = nums[i] ^ nums[j];
                        break;
                    }

                }
                if (j == nums.length) {
                    return i + 1;
                }
            }
        }
        return nums.length + 1;


    }
}
