package com.qiwx.test;

import com.qiwx.model.TreeNode;

/**
 * @description
 * @Author qiwx
 * @Date 2020-09-27 16:46
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 **/
public class MinimumDifference {
    TreeNode preNode = null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        order(root);
        return min;
    }

    public void order(TreeNode root) {
        if (root == null)
            return;
        order(root.left);
        if (preNode != null) {
            min = Math.min(min, root.val - preNode.val);
        }
        preNode = root;
        order(root.right);
    }


}
