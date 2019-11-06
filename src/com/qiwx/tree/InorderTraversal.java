package com.qiwx.tree;

import com.qiwx.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//中序遍历
public class InorderTraversal {
    public static void main(String[] args) {

    }
    public  static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        helper(root,list);
        return list;

    }
    public static void helper(TreeNode child,List<Integer> list){
          if(child!=null){
              if(child.left!=null){
                  helper(child.left,list);
              }
              list.add(child.val);
              if(child.right!=null){
                  helper(child.right,list);
              }
          }
    }
    //利用栈的特性
    public List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode curr=root;
        //结束条件 当前treeNode为null 或者 栈为空
        while (curr!=null||!stack.isEmpty()){
            //先将所有左节点放入栈中
            while (curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            //取出左节点
            curr=stack.pop();
            list.add(curr.val);
            //将右节点放入栈中
            curr=curr.right;

        }
        return list;
    }
}
