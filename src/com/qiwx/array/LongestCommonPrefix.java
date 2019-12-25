package com.qiwx.array;

//最长公共前缀
public class LongestCommonPrefix {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int len = strs.length;
        String marget = strs[0];
        for (int i = 0; i < marget.length(); i++) {
            char curChar = marget.charAt(i);
            for (int j = 1; j < len; j++) {
                if (i >= strs[j].length() || curChar != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(curChar);
        }
        return sb.toString();
    }
}
