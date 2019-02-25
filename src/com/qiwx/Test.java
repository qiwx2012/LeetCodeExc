package com.qiwx;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
//      List<Integer> list=new LinkedList<>();
//              list.add(1);
//              list.add(1);
//              list.add(2);
//              list.add(3);
//              list.remove(1);
//              System.out.println(list.size());

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
