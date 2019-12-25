package com.qiwx.string;

//Excel表列序号
public class TitleToNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("B"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int ratio = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            count += (chars[i] - 'A' + 1) * ((int) Math.pow(26, ratio));
            ratio++;

        }
        return count;


    }
}
