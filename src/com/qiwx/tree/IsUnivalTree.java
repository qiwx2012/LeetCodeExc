package com.qiwx.tree;

import com.qiwx.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

//965. 单值二叉树
public class IsUnivalTree {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(0);
        node.right=new TreeNode(0);
        isUnivalTree(node);
    }
    public static boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        int current=root.val;
        LinkedList<TreeNode> list=new LinkedList<>();
        list.add(root);
        while (list.size()>0){
            TreeNode node=list.pop();
            if(node.left!=null){
                if(node.left.val==current){
                    list.add(node.left);
                }else {
                    return false;
                }

            }
            if(node.right!=null){
                if(node.right.val==current){
                    list.add(node.right);
                }else {
                    return false;
                }
            }


        }
        return true;

    }
}
