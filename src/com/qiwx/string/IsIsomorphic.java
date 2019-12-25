package com.qiwx.string;

import java.util.HashMap;
import java.util.Map;

//同构字符串
public class IsIsomorphic {
    public static void main(String[] args) {
        //isIsomorphic("egg","add");
        //isIsomorphic("aa","ab");
        isIsomorphic("ab", "aa");
        //isIsomorphic("qwertyuiop[]asdfghjkl;'\\\\zxcvbnm,./","',.pyfgcrl/=aoeuidhtns-\\\\;qjkxbmwvz");
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (!map.containsValue(chart[i])) {
                map.put(chars[i], chart[i]);
            } else {
                if (map.get(chars[i]) == null || chart[i] != map.get(chars[i])) {
                    return false;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (chart[i] != map.get(chars[i])) {
                return false;
            }
        }
        return true;

    }
}
