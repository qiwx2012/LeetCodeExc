package com.qiwx.tree;

import com.qiwx.model.TreeNode;

import java.util.HashSet;
import java.util.Set;

//两数之和4
public class FindTarget {
    public static void main(String[] args) {
    }

    static Set<Integer> set = new HashSet<>();

    public static boolean findTarget(TreeNode root, int k) {

        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        }
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

    public static boolean findTarget1(TreeNode root, int k) {

        int target = 0;
        while (root != null) {
            target = k - root.val;
            if (root.left != null && root.right != null) {
                if (target == root.left.val) {
                    return true;
                } else if (target == root.right.val) {
                    return true;
                } else if (root.left.val + root.right.val == k) {
                    return true;
                } else if (set.contains(target)) {
                    return true;
                } else {
                    set.add(root.val);
                    set.add(root.left.val);
                    set.add(root.right.val);
                    findTarget(root.left, k);
                    findTarget(root.right, k);
                }
            } else if (root.left == null && root.right == null) {
                return false;
            } else {
                TreeNode tn = root.left == null ? root.right : root.left;
                if (tn.val == target) {
                    return true;
                } else if (set.contains(target)) {
                    return true;
                } else {
                    set.add(root.val);
                    set.add(tn.val);
                    findTarget(tn, k);
                }

            }

        }
        return false;

    }

}
