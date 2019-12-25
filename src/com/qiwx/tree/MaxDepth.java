package com.qiwx.tree;

import com.qiwx.model.TreeNode;

import java.util.Stack;

//二叉树最大深度
public class MaxDepth {
    public static void main(String[] args) {

    }

    int result = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return result;
    }
}
