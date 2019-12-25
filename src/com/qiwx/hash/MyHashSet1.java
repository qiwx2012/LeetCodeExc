package com.qiwx.hash;

//设计哈希表
public class MyHashSet1 {
    int[] set;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet1() {
        this.set = new int[1000001];
    }

    public void add(int key) {
        this.set[key] = 1;
    }

    public void remove(int key) {
        this.set[key] = 0;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return this.set[key] == 1;
    }
}
