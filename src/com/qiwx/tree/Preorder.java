package com.qiwx.tree;

import com.qiwx.model.Node;

import java.util.LinkedList;
import java.util.List;

//前序遍历  根->左->右
public class Preorder {
    public static void main(String[] args) {

    }

    //对于数的遍历，最佳实现是利用迭代结构来处理
    List<Integer> result = new LinkedList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return result;
        } else {
            result.add(root.val);
            for (Node node : root.children) {
                preorder(node);
            }
        }
        return result;

    }
}
