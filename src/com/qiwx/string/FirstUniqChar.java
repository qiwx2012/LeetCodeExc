package com.qiwx.string;

import java.util.*;

//字符串中的第一个唯一字符
public class FirstUniqChar {
    public static void main(String[] args) {
        //System.out.println(firstUniqChar2("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println(firstUniqChar("cc"));
        System.out.println(firstUniqChar("c"));
    }

    public static int firstUniqChar(String s) {
        int result = -1;
        if (s == null || s.length() == 0)
            return -1;
        int len = s.length();
        if (len == 1)
            return 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j)
                    continue;
                if (s.charAt(i) == s.charAt(j)) {
                    result = -1;
                    break;
                } else {
                    result = 0;
                }
            }
            if (result == 0) {
                return i;
            }
        }
        return result;
    }

    public static int firstUniqChar1(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(chars[i])) {
                if (map.get(chars[i]) != -1)
                    map.put(chars[i], -1);
            } else {
                map.put(chars[i], 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }
        return -1;

    }


}
