package com.qiwx.tree;

import com.qiwx.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

//二叉树的层平均值
public class AverageOfLevels {
    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            double avg = 0;
            int count = 0;
            //i初始化，倒序方式，每次循环完后重新赋值
            //i=list.size()每次循环的时候执行一次
            for (int i = list.size(); i > 0; i--) {
                TreeNode t = list.poll();
                avg += t.val;
                count++;
                if (t.left != null) list.offer(t.left);
                if (t.right != null) list.offer(t.right);
            }
            result.add((avg / count));
        }
        return result;

    }
}
