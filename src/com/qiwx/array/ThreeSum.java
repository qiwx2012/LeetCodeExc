package com.qiwx.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//三数之和
public class ThreeSum {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        // nums 数组排序后，要满足 sum == 0，必定有 nums[i] <= 0
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // 跳过相同值
            if (i != 0 && nums[i] == nums[i - 1]) continue;

            // 检索 [i + 1, nums.length) 区间，查找包含第 i 位元素且 sum 为 0 的所有组合
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                // sum 偏小或为 0，均需调整左边的指针（跳过相同值）
                if (sum <= 0) do j++; while (j < k && nums[j] == nums[j - 1]);

                // sum 偏大或为 0，均需调整右边的指针（跳过相同值）
                if (sum >= 0) do k--; while (j < k && nums[k] == nums[k + 1]);
            }
        }

        return result;


    }
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        int left=0;
        int right=nums.length;
        int count=0;
        while (right-left>2){
            count=nums[left]+nums[right];
            if(count<0){
                if(count+nums[right]<0){
                    left++;
                    right++;
                }else if(count+nums[right]>0){
                    count=0;
                    right--;
                }else {
                    left--;
                    right++;
                }
            }else {
                
            }


        }

        return result;


    }
}
