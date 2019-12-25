package com.qiwx.string;

import java.util.Stack;

//比较含退格的字符串
public class BackspaceCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f", "y#fx#o##f"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "b"));
    }

    public static boolean backspaceCompare(String S, String T) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(S.charAt(i));
            }
        }
        int num = 0;//有多少个#退格键没有处理，当遇到非#时优先处理
        for (int i = T.length() - 1; i >= 0; i--) {
            if (T.charAt(i) == '#') {
                num++;
            } else {
                if (num > 0) {
                    num--;
                } else {
                    if (T.charAt(i) != stack.pop()) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean backspaceCompare1(String S, String T) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(S.charAt(i));
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            } else {
                stack1.add(T.charAt(i));
            }
        }
        return stack.equals(stack1);
    }
}
