package com.qiwx.bit;

import com.qiwx.model.TreeNode;

//数组中两个数的最大异或值
public class FindMaximumXOR {
    public static void main(String[] args) {

    }

    public static int findMaximumXOR(int[] nums) {
        TreeNode root = new TreeNode(-1);
        // build the tree
        for(int n : nums) {
            TreeNode node = root;
            for(int i = 31; i>=0; i--) {
                if ((n & (1 << i)) == 0) { // 如果等于0表示高位为0
                    if (node.left == null) {
                        node.left = new TreeNode(0);
                    }
                    node = node.left;
                } else { // 1
                    if (node.right == null) {
                        node.right = new TreeNode(1);
                    }
                    node = node.right;
                }
            }
            node.left = new TreeNode(n);
        }

        int max = 0;
        for(int n: nums) {
            TreeNode node = root;
            for(int i=31; i>=0; i--) {
                if ((n & (1<<i)) == 0) {
                    if (node.right != null) {
                        node = node.right;
                    } else {
                        node = node.left;
                    }
                } else {
                    if (node.left != null) {
                        node = node.left;
                    } else {
                        node = node.right;
                    }
                }
            }
            int nn = node.left.val;
            max = Math.max(max, n ^ nn);
        }
        return max;


    }
}
