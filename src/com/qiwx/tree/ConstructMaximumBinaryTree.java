package com.qiwx.tree;

import com.qiwx.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

//最大二叉树
public class ConstructMaximumBinaryTree {
    public static void main(String[] args) {
        constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int len = nums.length - 1;
        TreeNode res = addTree(nums, 0, len);
        return res;


    }

    private static TreeNode addTree(int[] nums, int start, int end) {

        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        if (maxIndex > start)
            root.left = addTree(nums, start, maxIndex - 1);
        if (maxIndex < end)
            root.right = addTree(nums, maxIndex + 1, end);
        return root;
    }

}
