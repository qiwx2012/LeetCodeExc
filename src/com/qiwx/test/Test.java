package com.qiwx.test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        SoftReference<A> sf = new SoftReference(a);
        WeakReference<A> wf = new WeakReference<>(a);
        wf.get();
        sf.get();
//        Object object = new Object();
//        Object[] objArr = new Object[Integer.MAX_VALUE];
        WeakReference<A> reference = new WeakReference<A>(new A());
        System.out.println(reference.get());
        System.gc();//通知GVM回收资源
        System.out.println(reference.get());
        WeakHashMap whm = new WeakHashMap();
        whm.put("key", "value");
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(1);
        list.add(6);
        list.add(2);
        list.add(3);
        list.remove(1);
        Collections.sort(list);
        System.out.println(list.size());
        for (int i = list.size(); i >= 0; i--) {
            list.poll();
            list.push(10);
        }


        StringBuffer sb = new StringBuffer();
        sb.append("abcd");
        StringBuffer sb2 = sb;
        sb.append("ffff");
        System.out.println(sb.toString());
        System.out.println(sb2.toString());
        HashMap hashMap;
        Hashtable hashtable;
        ConcurrentHashMap concurrentHashMap;


    }
}
