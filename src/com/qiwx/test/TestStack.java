package com.qiwx.test;

import java.util.LinkedList;

public class TestStack {
    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        int len=list.size();
        for(int i=0;i<len;i++){
            System.out.println(list.pollLast());
        }

    }

}
