package com.qiwx;

import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
      List<Integer> list=new LinkedList<>();
              list.add(1);
              list.add(1);
              list.add(2);
              list.add(3);
              list.remove(1);
              System.out.println(list.size());

    }
}
