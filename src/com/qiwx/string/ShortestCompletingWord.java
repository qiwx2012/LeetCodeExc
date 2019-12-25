package com.qiwx.string;

import java.util.Stack;

//最短完整词
public class ShortestCompletingWord {
    public static void main(String[] args) {
        System.out.println(shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < licensePlate.length(); i++) {
            char ch = licensePlate.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                stack.push(Character.toLowerCase(ch));
            }
        }
        int current = 0;
        int currentSize = 16;
        for (int i = 0; i < words.length; i++) {
            String temp = words[i].toLowerCase();
            boolean isTrue = true;
            for (char ch : stack) {
                if (temp.indexOf(String.valueOf(ch)) < 0) {
                    isTrue = false;
                    break;
                } else {
                    temp = temp.replaceFirst(String.valueOf(ch), "");
                }
            }
            if (isTrue) {
                if (words[i].length() < currentSize) {
                    currentSize = words[i].length();
                    current = i;
                }
            }

        }
        return words[current];

    }
}
