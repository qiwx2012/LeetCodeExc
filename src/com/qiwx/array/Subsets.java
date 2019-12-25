package com.qiwx.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//子集
public class Subsets {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList();
        List<Integer> temp = new LinkedList();
        addChild(result, temp, nums, 0);
        return result;


    }

    private void addChild(List<List<Integer>> res, List<Integer> temp, int[] nums, int j) {
        res.add(new LinkedList(temp));
        for (int i = j; i < nums.length; i++) {
            temp.add(nums[i]);  //① 加入 nums[i]
            addChild(res, temp, nums, i + 1);  //② 递归
            temp.remove(temp.size() - 1);  //③ 移除 nums[i]
        }

    }
}
