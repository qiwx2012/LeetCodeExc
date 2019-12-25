package com.qiwx.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//验证外星语词典
public class IsAlienSorted {
    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        //System.out.println(isAlienSorted(new String[]{"kuvp","q "},"ngxlkthsjuoqcpavbfdermiywz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> maps = new HashMap<>();
        int len = words.length;
        char[] chars = order.toCharArray();
        for (int i = 0; i < order.length(); i++) {
            maps.put(chars[i], i);
        }
        for (int i = 0; i < len - 1; i++) {
            int l1 = words[i].length();
            int l2 = words[i + 1].length();
            int min = 0;
            //给短字符补一个空格方便计算
            if (l1 < l2) {
                words[i] = words[i] + " ";
                min = l1 + 1;
            } else {
                words[i + 1] = words[i + 1] + " ";
                min = l2 + 1;
            }
            //先从前两个开始比较，如果满足条件继续下一个知道最后
            //比较过程中先比较第一个字符如果满足直接跳出循环，如果相等
            //继续第二个字符，直到短字符遇到空格截止，因为空格是-1，肯定最小
            for (int j = 0; j < min; j++) {
                int a = maps.getOrDefault(words[i].charAt(j), -1);
                int b = maps.getOrDefault(words[i + 1].charAt(j), -1);
                if (a > b) {
                    return false;
                } else if (a < b) {
                    break;
                }
            }
        }
        return true;


    }
}
