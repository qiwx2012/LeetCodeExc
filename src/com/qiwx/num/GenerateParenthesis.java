package com.qiwx.num;

import java.util.LinkedList;
import java.util.List;

//括号生成
public class GenerateParenthesis {
    public static void main(String[] args) {

    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        parenthesis(result, "", n, n);
        return result;
    }

    private static void parenthesis(List<String> ll, String sublist, int left, int right) {
        if (left == 0 && right == 0) {
            ll.add(sublist);
        }
        if (right > left) {
            parenthesis(ll, sublist + ")", left, right - 1);
        }
        if (left > 0) {
            parenthesis(ll, sublist + "(", left - 1, right);
        }
    }
}
