package qiwx.demo;

import java.util.LinkedList;

public class TestList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (int i = 0; i < 3; i++) {
            //System.out.println(list.pop());
            System.out.println(list.pollFirst());
        }

    }
}
