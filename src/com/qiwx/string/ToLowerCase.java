package com.qiwx.string;

//转换成小写字母
public class ToLowerCase {

    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello"));

    }

    private static String toLowerCase(String str) {
        // str.toLowerCase();
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
//                chars[i]=(char)(chars[i]+32);
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        return new String(chars);
    }
}
