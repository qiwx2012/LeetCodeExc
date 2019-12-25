package com.qiwx.stack;

import java.util.Collections;
import java.util.LinkedList;

public class MinStack {
    /**
     * initialize your data structure here.
     */
    private LinkedList<Integer> data = null;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        data = new LinkedList<>();
    }

    public void push(int x) {
        data.add(x);
        if (min > x) {
            min = x;
        }
    }

    public void pop() {
        if (!data.isEmpty()) {
            Integer i = data.pollLast();
            if (i == min) {
                //如果弹出的是最小值，重新再查找出最小值
                min = Integer.MAX_VALUE;
                for (Integer value : data) {
                    min = min > value ? value : min;
                }
            }
        }

    }

    public int top() {
        return data.peekLast();
    }

    public int getMin() {
        return min;
    }
}
