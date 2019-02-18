package com.qiwx.tree;

import com.qiwx.model.Node;

import java.util.LinkedList;
import java.util.List;

//后序遍历 左->右->跟
public class Postorder {
    public static void main(String[] args) {

    }
    static List<Integer> result=new LinkedList<>();
    public static List<Integer> postorder(Node root) {
        if(root==null){
            return result;
        }else {
            for(Node node:root.children){
                postorder(node);
            }
            result.add(root.val);
        }
        return result;

    }
}
