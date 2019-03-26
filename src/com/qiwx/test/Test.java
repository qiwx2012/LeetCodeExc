package com.qiwx.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();
              list.add(1);
              list.add(1);
              list.add(6);
              list.add(2);
              list.add(3);
              list.remove(1);
              Collections.sort(list);
              System.out.println(list.size());
              for(int i=list.size();i>=0;i--){
                  list.poll();
                  list.push(10);
              }


        StringBuffer sb=new StringBuffer();
        sb.append("abcd");
        StringBuffer sb2=sb;
        sb.append("ffff");
        System.out.println(sb.toString());
        System.out.println(sb2.toString());
        HashMap hashMap;
        Hashtable hashtable;
        ConcurrentHashMap concurrentHashMap;


    }
}
