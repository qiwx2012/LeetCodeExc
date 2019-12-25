package com.qiwx.tree;

import com.qiwx.model.TreeNode;

//合并二叉树
public class MergeTrees {
    public static void main(String[] args) {

    }

    static TreeNode result = new TreeNode(0);

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        //合并子树
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;

    }

    private static TreeNode addTree(TreeNode result, TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return result;
        }
        if (t1 != null && t2 != null) {
            result.val = t1.val + t2.val;
            addTree(result.left, t1.left, t2.left);
            addTree(result.right, t1.right, t2.right);
        } else if (t1 != null) {
            result.val = t1.val;
            addTree(result.left, t1.left, null);
            addTree(result.right, t1.right, null);
        } else {
            result.val = t2.val;
            addTree(result.left, t2.left, null);
            addTree(result.right, t2.right, null);

        }
        return result;

    }
}
