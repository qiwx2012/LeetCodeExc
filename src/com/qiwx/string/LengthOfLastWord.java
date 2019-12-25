package com.qiwx.string;

//最后一个单词的长度
public class LengthOfLastWord {
    public static void main(String[] args) {
        // System.out.println(lengthOfLastWord1("Hello World"));
        //  System.out.println(lengthOfLastWord1("a "));
        System.out.println(lengthOfLastWord1("   a  "));
    }

    private static int lengthOfLastWord1(String s) {
        String[] str = s.split(" ");
        if (str.length == 0)
            return 0;
        else {
            return str[str.length - 1].length();
        }
    }

    private static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        s = s.trim();
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else {
                return count;
            }

        }
        return count;
    }
}
