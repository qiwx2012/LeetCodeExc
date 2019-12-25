package com.qiwx.string;

import java.util.LinkedList;
import java.util.Stack;

//基本计算器
public class Calculate2 {
    public static void main(String[] args) {
        //System.out.println(calculate("1-(2+3-(4+(5-(1-(2+4-(5+6))))))"));
        //System.out.println(calculate("(1-(3-4))"));
        //System.out.println(calculate("2-(5-6)"));
        System.out.println(calculate("2-(5)"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public static int calculate(String s) {
        int res = 0, num = 0, sign = 1, n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = 10 * num + (c - '0');
            } else if (c == '(') {
                int start = i + 1;
                int count = 0;
                while (true) {
                    char c1 = s.charAt(i);
                    if (c1 == '(') {
                        ++count;
                    } else if (c1 == ')') {
                        --count;
                    }
                    if (count == 0)
                        break;
                    i++;

                }
                String s1 = s.substring(start, i);
                num = calculate(s1);
            }
            if (c == '+' || c == '-' || i == n - 1) {
                res += sign * num;
                num = 0;
                sign = (c == '+') ? 1 : -1;
            }
        }
        return res;
    }

    public static int calculate1(String s) {
        int res = 0, sign = 1, n = s.length();
        LinkedList<Integer> st = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (c >= '0') {
                int num = 0;
                while (i < n && s.charAt(i) >= '0') {
                    num = 10 * num + s.charAt(i + 1) - '0';
                }
                res += sign * num;
                --i;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res *= st.pop();
                st.pop();
                res += st.pop();
                st.pop();
            }
        }
        return res;
    }

}
