package com.qiwx.string;

//词典中最长单词
public class LongestWord {
    public static void main(String[] args) {
        System.out.println(longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }

    private static String longestWord(String[] words) {
        String result = "";
        int len = result.length();
        for (int i = 0; i < 30; i++) {

            if (words[i].length() > len) {
                result = words[i];
                len = result.length();
            } else if (words[i].length() == len) {
                for (int j = 0; j < len; j++) {
                    if (words[i].charAt(j) < result.charAt(j)) {
                        result = words[i];
                        break;
                    }
                }

            }
        }
        return result;
    }
}
