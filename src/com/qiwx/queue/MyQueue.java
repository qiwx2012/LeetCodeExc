package com.qiwx.queue;

import java.util.Stack;

//232. 用栈实现队列
public class MyQueue {
        Stack<Integer> stack=null;
        public MyQueue() {
            stack=new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stack.push(x);

        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            Stack<Integer> temp=new Stack<>();
            while(!stack.isEmpty()){
                temp.push(stack.pop());
            }
            int result=temp.isEmpty()?-1:temp.pop();
            while(!temp.isEmpty()){
                stack.push(temp.pop());
            }
            return result;

        }

        /** Get the front element. */
        public int peek() {
            Stack<Integer> temp=new Stack<>();
            while (!stack.isEmpty()){
                temp.push(stack.pop());
            }
            int result=temp.isEmpty()?-1:temp.peek();
            while(!temp.isEmpty()){
                stack.push(temp.pop());
            }
            return result;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stack.isEmpty();

        }

}
