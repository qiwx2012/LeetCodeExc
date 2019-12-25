package com.qiwx.string;

//翻转字符串2
public class ReverseStr {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
        System.out.println(reverseStr("abcd", 4));
    }

    public static String reverseStr(String s, int k) {
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        int k2 = 2 * k;
        int index = 0;
        while (len > 0) {
            if (len - k2 >= 0) {
                index = k2;
            } else {
                index = len;
            }
            int min = Math.min(len, k);
            int j = sb.length();
            for (int i = min - 1; i >= 0; i--) {
                sb.append(s.charAt(j + i));
            }
            int len1 = sb.length();
            String s2 = s.substring(len1, len1 + (index - min));
            sb.append(s2);
            if (index % k2 == 0) {
                len = len - k2;
            } else {
                len = 0;
            }

        }

        return sb.toString();
    }

    public String reverseStr1(String s, int k) {
        int len = s.length();
        StringBuffer sb = new StringBuffer();
        String s1;
        int k2 = 2 * k;
        while (len > 0) {
            if (len - k2 >= 0) {
                s1 = s.substring(0, k2);
            } else {
                s1 = s.substring(0, len);

            }
            int min = Math.min(len, k);
            for (int i = min - 1; i >= 0; i--) {
                sb.append(s1.charAt(i));
            }
            sb.append(s1.substring(min));
            if (s1.length() == k2) {
                s = s.substring(k2);
                len = s.length();
            } else {
                break;
            }
        }

        return sb.toString();
    }
}
