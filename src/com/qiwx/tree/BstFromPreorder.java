package com.qiwx.tree;

import com.qiwx.model.TreeNode;

//先序遍历构造二叉树
public class BstFromPreorder {
    public static void main(String[] args) {

    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode current = new TreeNode(preorder[0]);
        int num=preorder.length;
        for(int i=1;i<preorder.length;i++){
            if(preorder[i]>preorder[0]){
                num=i;
                break;
            }
        }
        //核心算法是将数组按左右子数递归计算
        if(num-1>0){
            int[] left=new int[num-1];
            for(int i=0;i<num-1;i++){
                left[i]=preorder[i+1];
            }
            current.left=bstFromPreorder(left);
        }
        if(preorder.length-num>0){
            int[] right=new int[preorder.length-num];
            for(int i= num;i<preorder.length;i++){
                right[i-num]=preorder[i];
            }
            current.right=bstFromPreorder(right);
        }
        return current;


    }
}
