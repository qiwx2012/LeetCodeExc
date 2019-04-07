package com.qiwx.test;

import java.util.LinkedList;
import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
        //add和push结果是一样的 ,push 返回插入值
        //add 返回是否插入成功
        stack.push(4);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        int len=stack.size();
        for(int i=0;i<len;i++){
            System.out.println(stack.pop());
        }

    }

}
