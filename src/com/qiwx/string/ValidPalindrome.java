package com.qiwx.string;

//验证回文字符串 Ⅱ
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println(validPalindrome("abca"));
    }

    public static boolean validPalindrome(String s) {
        return vaild(s, 0, s.length() - 1, 1);

    }

    public static boolean vaild(String s, int i, int j, int flag) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            } else {
                if (flag == 1) {
                    return vaild(s, i + 1, j, 0) || vaild(s, i, j - 1, 0);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
