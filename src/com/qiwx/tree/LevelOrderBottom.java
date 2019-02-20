package com.qiwx.tree;

import com.qiwx.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

//二叉树的层次遍历 II
public class LevelOrderBottom {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result=new LinkedList<>();
        if(root==null)
            return result;
        List<TreeNode> nodes=new LinkedList<>();
        List<TreeNode> nodes1=new LinkedList<>();
        nodes.add(root);
        List<Integer> list;

        while (nodes.size()!=0){
             list=new LinkedList<>();
             for(TreeNode node:nodes){
                 list.add(node.val);
                 if(node.left!=null){
                     nodes1.add(node.left);
                 }
                 if(node.right!=null){
                     nodes1.add(node.right);
                 }
             }
             nodes.clear();
             nodes.addAll(nodes1);
             nodes1.clear();
            result.addFirst(list);
        }
        return result;
    }


}
