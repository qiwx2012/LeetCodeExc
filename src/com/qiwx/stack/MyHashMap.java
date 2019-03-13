package com.qiwx.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//设计哈希映射
public class MyHashMap {
    /** Initialize your data structure here. */

      private LinkedList<Integer> list=null;
      public MyHashMap() {
            list =new LinkedList<>();
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int size=list.size();
            if(size<key){
                for(int i=size;i<=key;i++){
                    list.add(i,null);
                }
            }
            list.set(key,value);
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            if(key<list.size()){
                return list.get(key)==null?-1:list.get(key);
            }
            return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        if(key<list.size()){
            list.set(key,null);
        }
    }
}
