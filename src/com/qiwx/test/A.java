package com.qiwx.test;

import java.util.LinkedList;
import java.util.List;

public class A {
    public static void main(String[] args) {
        AA aa = new AA();
        System.out.println("数组大小" + aa.getList().size());
        aa.getList().clear();
        System.out.println(aa.getList().size());

    }

}

class AA {
    private List<String> list = new LinkedList<>();

    public AA() {
        list.add("hello");
    }


    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
