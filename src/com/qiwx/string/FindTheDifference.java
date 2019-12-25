package com.qiwx.string;

//找不同
public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("a", "aa"));
        System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(findTheDifference(null, "a"));
        System.out.println(findTheDifference("", "b"));
    }

    public static char findTheDifference(String s, String t) {
        if (s == null) {
            return t.toCharArray()[0];
        }
        char[] chars = s.toCharArray();
        int len = t.length();
        for (int i = 0; i < len - 1; i++) {
            t = t.replaceFirst(String.valueOf(chars[i]), "");
        }
        return t.charAt(0);
    }

    public static char findTheDifference1(String s, String t) {
        if (s == null) {
            return t.charAt(0);
        }
        char[] chars = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int result = 0;
        int len = t.length();
        //对于两个集合找不同，如果只有一个不同可以利用异或操作
        //来着不同
        for (int i = 0; i < len - 1; i++) {
            result = (chars[i] ^ chars2[i]) ^ result;
        }
        return (char) (result ^ chars2[len - 1]);
    }
}
