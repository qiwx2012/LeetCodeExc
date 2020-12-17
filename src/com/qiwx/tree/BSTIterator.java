package com.qiwx.tree;

import com.qiwx.model.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BSTIterator {
    Queue<Integer> queue=new LinkedList<>();
    public BSTIterator(TreeNode root){
       inorderTraversal(root);
    }
    //将树按照中序遍历放到队列中
    private void inorderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        queue.offer(root.val);
        inorderTraversal(root.right);
    }
    /** @return the next smallest number */
    public int next() {
        return queue.poll();

    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
           return !queue.isEmpty();
    }
}
