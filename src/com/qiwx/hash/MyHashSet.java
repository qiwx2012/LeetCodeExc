package com.qiwx.hash;

import java.util.LinkedList;
import java.util.List;

//设计哈希表
public class MyHashSet {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        System.out.println(myHashSet.contains(1));
        System.out.println(myHashSet.contains(3));
        myHashSet.add(2);
        System.out.println(myHashSet.contains(2));

    }

    /**
     * Initialize your data structure here.
     */
    List<Integer> list = null;

    public MyHashSet() {
        list = new LinkedList<>();
    }

    public void add(int key) {
        if (!list.contains(key))
            list.add(key);
    }

    public void remove(int key) {
        list.remove(Integer.valueOf(key));
    }

    /**
     * Retuerns true if this set contains the specified element
     */
    public boolean contains(int key) {

        return list.contains(Integer.valueOf(key));

    }
}
