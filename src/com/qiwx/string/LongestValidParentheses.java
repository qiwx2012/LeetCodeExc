package com.qiwx.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description
 * @Author qiwx
 * @Date 2020-12-22 13:52
 * 最长有效括号
 **/
public class LongestValidParentheses {
    public static void main(String[] args) {
//      System.out.println(longestValidParentheses("(()"));
      System.out.println(longestValidParentheses("()(()"));
      System.out.println(longestValidParentheses(")()())"));
      System.out.println(longestValidParentheses("(()()((()()()()"));
    }

    //解题思路 一个有效括号 右括号肯定与做括号相等，可以统计合法右括号有几个
    public static int longestValidParentheses(String s) {

        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;




    }
}
