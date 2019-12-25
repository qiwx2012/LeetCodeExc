package com.qiwx.string;

import java.util.HashSet;
import java.util.Set;

//山羊拉丁文
public class ToGoatLatin {
    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }

    public static String toGoatLatin(String S) {
        String[] strs = S.split(" ");
        int len = strs.length;
        String vowel = "AEIOU";
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < vowel.length(); i++) {
            set.add(vowel.charAt(i));
        }
        StringBuffer append = new StringBuffer();
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < len; i++) {
            append.append("a");
            if (set.contains(Character.toUpperCase(strs[i].charAt(0)))) {
                result.append(strs[i] + "ma" + append.toString() + " ");
            } else {
                String index = strs[i].substring(0, 1);
                result.append(strs[i].substring(1) + index + "ma" + append.toString() + " ");
            }
        }
        return result.toString().trim();
    }
}
