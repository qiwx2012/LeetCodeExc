package com.qiwx.array;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @description
 * @Author qiwx
 * @Date 2020-12-16 16:04
 * 数组中重复的数字
 **/
public class FindRepeatNumber {

    public static void main(String[] args) {

    }

    public static int findRepeatNumber(int[] nums) {
        int len=nums.length;
        byte[] keys=new byte[len];
        for (int i = 0; i < len; i++) {
            if(keys[nums[i]]==0){
                keys[nums[i]]++;
            }else {
                return nums[i];
            }
        }
        return 0;
    }
    public static int findRepeatNumber1(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num :nums){
            if(!set.add(num)){
                return num;
            }
        }

        return 0;
    }
}
