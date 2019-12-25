package com.qiwx.tree;

import com.qiwx.model.TreeNode;

public class IsSameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(3);
        q.right = new TreeNode(2);
        isSameTree(p, q);

    }

    //递归方式
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null && p.val == q.val) {
            return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
        } else {
            return false;
        }
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        TreeNode treeNodeP = p;
        TreeNode treeNodeQ = q;
        //先遍历左节点是否相同
        boolean result = true;
        boolean isLeftSame = false; //左节点是否相等
        for (int i = 0; i < 2; i++) {
            while (treeNodeP != null || treeNodeQ != null) {
                if (treeNodeP != null && treeNodeQ != null) {
                    if (treeNodeP.val == treeNodeQ.val) {
                        if (!isLeftSame) {
                            treeNodeP = treeNodeP.left;
                            treeNodeQ = treeNodeQ.left;
                        } else {
                            treeNodeP = treeNodeP.right;
                            treeNodeQ = treeNodeQ.right;
                        }
                    } else {
                        result = false;
                        break;
                    }

                } else {
                    result = false;
                    break;
                }
            }
            //如果不想等 不需要再继续查找
            if (!result) {
                break;
            } else {
                treeNodeP = p;
                treeNodeQ = q;
                isLeftSame = true;
            }
        }

        //再遍历右节点
        return result;
    }
}
