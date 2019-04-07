package com.qiwx.test;

import com.qiwx.queue.MyQueue;

public class TestMyQueue {
    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
    }
}
