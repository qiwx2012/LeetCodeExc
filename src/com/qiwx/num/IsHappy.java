package com.qiwx.num;

import java.util.Stack;

//快乐数
public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    private static boolean isHappy(int n) {
        Stack<Integer> stack = new Stack<>();
        if (n == 1)
            return true;
        stack.push(n);
        while (n != 1) {
            int count = 0;
            int in = n;
            while (in > 0) {
                int temp = in % 10;
                count += temp * temp;
                in = in / 10;
            }
            if (stack.contains(count)) {
                return false;
            } else {
                stack.push(count);
            }
            n = count;
        }

        return true;
    }
}
