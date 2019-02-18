package com.qiwx.tree;

import com.qiwx.model.Node;

import java.util.LinkedList;
import java.util.List;

//N叉树的层序遍历 从左到右，逐层遍历
public class LevelOrder {
    public static void main(String[] args) {
        Node c1=new Node(5,null);
        Node c2=new Node(6,null);
        List<Node> l2=new LinkedList<>();
        l2.add(c1);
        l2.add(c2);

    }
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result=new LinkedList<>();
        if(root==null)
            return result;
          List<Node> nodes=root.children;
        List<Integer> list=new LinkedList<>();
        list.add(root.val);
        result.add(list);
        while (nodes.size()!=0){
            List<Node> temp=new LinkedList<>();
            List<Integer> list1=new LinkedList<>();
            for (Node node:nodes){
                if(node.children!=null){
                    temp.addAll(node.children);
                }
                list1.add(node.val);
            }
            result.add(list1);
            nodes=temp;
        }
        return result;
    }
}
