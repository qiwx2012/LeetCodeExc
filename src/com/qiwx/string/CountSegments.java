package com.qiwx.string;

//字符串中的单词数
public class CountSegments {
    public static void main(String[] args) {
        System.out.println(countSegments("Hello, my name is John"));
        System.out.println(countSegments(", , , ,   a, eaefa"));
    }

    private static int countSegments(String s) {
        int count = 0;
        int wordLen = 0;//单词长度
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                wordLen = 0;
            }
            if (c != ' ' && wordLen == 0) {
                count++;
                wordLen = 1;
            }

        }
        return count;

    }
}
