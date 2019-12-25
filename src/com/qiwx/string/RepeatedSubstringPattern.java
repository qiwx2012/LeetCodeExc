package com.qiwx.string;

//重复的子字符串
public class RepeatedSubstringPattern {
    public static void main(String[] args) {

        System.out.println(repeatedSubstringPattern("aabaaba"));
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
    }

    private static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int half = len / 2;
        for (int i = 1; i <= half; i++) {
            String t = s.substring(0, i);
            int size = t.length();
            boolean flag = true;
            for (int j = 0; j < len; j = j + size) {
                int end = j + size > len ? len : j + size;
                if (!t.equals(s.substring(j, end))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }

        }

        return false;

    }

    private static boolean repeatedSubstringPattern1(String s) {
        int len = s.length();


        return false;
    }

}
