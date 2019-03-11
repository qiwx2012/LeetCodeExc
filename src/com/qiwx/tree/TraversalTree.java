package com.qiwx.tree;

import com.qiwx.model.Node;
import com.qiwx.model.TreeNode;

import java.util.LinkedList;

//二叉树遍历练习
public class TraversalTree {
    public static void main(String[] args) {

    }
    //中序遍历 左子树->根节点->右子树
    private void infixOrder(TreeNode node){
        if(node!=null){
            infixOrder(node.left);
            System.out.println(node.val);
            infixOrder(node.right);
        }
    }
    //前序遍历 根节点->左子树->右子树
    public void preOrder(TreeNode current){
        if(current != null){
            System.out.print(current.val+" ");
            preOrder(current.left);
            preOrder(current.right);
        }
    }
    //后序遍历 左子树->右子树->根节点
    public void postOrder(TreeNode current){
        if(current != null){
            postOrder(current.left);
            postOrder(current.right);
            System.out.print(current.val+" ");
        }
    }
    //深度优先
    public void depthOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val+"  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
    //层次遍历
    public void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val+"  ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }



}
