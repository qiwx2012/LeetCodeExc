package com.qiwx.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//有效括号
public class IsValid {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        // System.out.println(isValid("()[]{}"));
        //System.out.println(isValid("(]"));
        //System.out.println(isValid("{[]}"));
    }

    private static boolean isValid(String s) {
        if (s == null || s.length() == 1)
            return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        char[] str = s.toCharArray();
        Stack<Character> stacks = new Stack<>();
        for (int i = 0; i < str.length; i++) {
            char c = s.charAt(i);
            if (map.containsValue(c)) {
                stacks.push(c);
            } else {
                char topElement = stacks.isEmpty() ? '1' : stacks.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            }
        }
        return stacks.isEmpty();

    }
}
