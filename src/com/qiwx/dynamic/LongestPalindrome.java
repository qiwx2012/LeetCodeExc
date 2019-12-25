package com.qiwx.dynamic;

//最长回文字符串
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("dd"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1)
            return s;
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }
        String result = "";
        //先找最大字符串是不是回文字符串如果是就不需要再继续找下去
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String temp = childLogest(s.substring(j, i));
                if (temp.length() > result.length()) {
                    result = temp;
                }
            }
        }
        return result;

    }

    private static String childLogest(String str) {
        int len = str.length();
        int left = 0;
        int right = 0;
        int mid = len / 2;
        StringBuffer sb = new StringBuffer();
        if (len % 2 == 0) {
            left = mid - 1;
            right = mid;
        } else {
            left = mid - 1;
            right = mid + 1;
            sb.append(str.charAt(mid));

        }
        while (left >= 0 & right < len) {
            if (str.charAt(left) == str.charAt(right)) {
                sb.insert(0, str.charAt(left));
                sb.append(str.charAt(right));
                if (left == 0 || right == str.length() - 1) {
                    break;
                } else {
                    left--;
                    right++;
                }
            } else {
                break;
            }
        }
        return sb.toString();

    }

    public String findPalindrome(String s, int left, int right) {
        int n = s.length();
        int l = left;
        int r = right;
        while (l >= 0 && r <= n - 1 && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public String longestPalindrome1(String s) {
        int n = s.length();
        if (n <= 1) return s;

        String longest = "";

        String str;
        for (int i = 0; i < n - 1; i++) {
            str = findPalindrome(s, i, i);
            if (str.length() > longest.length()) {
                longest = str;
            }
            str = findPalindrome(s, i, i + 1);
            if (str.length() > longest.length()) {
                longest = str;
            }
        }

        return longest;
    }
}
