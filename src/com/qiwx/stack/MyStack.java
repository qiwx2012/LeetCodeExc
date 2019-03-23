package com.qiwx.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    /** Initialize your data structure here. */
    LinkedList<Integer> data=null;
    public MyStack() {
        data=new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        data.add(x);

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!data.isEmpty())
         return data.pollLast();
        return -1;

    }

    /** Get the top element. */
    public int top() {
      return data.peekLast();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return data.isEmpty();

    }
}
