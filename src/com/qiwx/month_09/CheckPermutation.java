package com.qiwx.month_09;

/**
 * @description
 * @Author qiwx
 * @Date 2020-09-28 16:43
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 **/
public class CheckPermutation {

    public static void main(String[] args) {
        System.out.println(new CheckPermutation().checkPermutation("abc","bca"));
        System.out.println(new CheckPermutation().checkPermutation("abc","bad"));
        System.out.println(new CheckPermutation().checkPermutation("asvnpzurz", "urzsapzvn"));

    }

    public boolean checkPermutation(String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;
        if (s1 == null || s2 == null)
            return false;
        if (s1.length() != s2.length())
            return false;
        //只需要判断 s1和s2 字母数必须是0
        int[] chars = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i)]++;
            chars[s2.charAt(i)]--;
        }
        for (int i = 0; i < 128; i++) {
            if (chars[i] != 0 ) {
                return false;
            }

        }
        return true;


    }
}
