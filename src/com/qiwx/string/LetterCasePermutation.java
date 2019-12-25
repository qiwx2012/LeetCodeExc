package com.qiwx.string;

import java.util.*;

//字母大小写全排列
public class LetterCasePermutation {
    public static void main(String[] args) {
        letterCasePermutation("a1b2");
    }

    public static List<String> letterCasePermutation(String S) {

        List<String> result = new LinkedList<>();
        List<String> temp = new LinkedList<>();
        if (S == null || S.length() == 0) {
            result.add("");
            return result;
        }
        int len = S.length();
        char[] chars = S.toCharArray();
        int size;
        for (int i = 0; i < len; i++) {
            size = result.size();
            char c1 = chars[i];
            if (size == 0) {
                if (c1 >= '0' && c1 <= '9') {
                    result.add(String.valueOf(c1));
                } else {
                    temp.add(String.valueOf(c1));
                    if (c1 >= 'a' && c1 <= 'z') {
                        temp.add(String.valueOf(Character.toUpperCase(c1)));
                    } else {
                        temp.add(String.valueOf(Character.toLowerCase(c1)));
                    }
                    result.add(String.valueOf(Character.toLowerCase(c1)));
                    result.add(String.valueOf(Character.toUpperCase(c1)));
                }
            } else {
                if (c1 >= '0' && c1 <= '9') {
                    for (int j = 0; j < size; j++) {
                        result.set(j, result.get(j) + c1);
                    }
                } else {
                    temp.clear();
                    for (int j = 0; j < size; j++) {
                        temp.add(result.get(j) + c1);
                        if (c1 >= 'a' && c1 <= 'z') {
                            temp.add(result.get(j) + Character.toUpperCase(c1));
                        } else {
                            temp.add(result.get(j) + Character.toLowerCase(c1));
                        }

                    }
                    result.clear();
                    result.addAll(temp);
                }
            }
        }
        return result;

    }
}
