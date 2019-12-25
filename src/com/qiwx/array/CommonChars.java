package com.qiwx.array;

import java.util.LinkedList;
import java.util.List;

//1002. 查找常用字符
public class CommonChars {
    public static void main(String[] args) {
        commonChars(new String[]{"bella", "label", "roller"});
    }

    public static List<String> commonChars(String[] A) {
        List<String> result = new LinkedList<>();
        if (A.length <= 1)
            return result;
        String target = A[0];
        for (int i = 0; i < target.length(); i++) {
            String c = Character.toString(target.charAt(i));
            boolean isHave = true;
            for (int j = 1; j < A.length; j++) {
                if (A[j].contains(c)) {
                    A[j] = A[j].replaceFirst(c, "");
                } else {
                    isHave = false;
                    break;
                }

            }
            if (isHave) {
                result.add(c);
            }

        }

        return result;
    }

    private List<String> commonChars1(String[] A) {
        List<String> result = new LinkedList<>();
        if (A == null || A.length <= 0) {
            return result;
        }

        int[] chars = new int[26];//定义26个字母数组
        for (int i = 0; i < 26; i++) {
            chars[i] = Integer.MAX_VALUE;
        }
        for (String a : A) {
            char[] content = a.toCharArray();
            int[] charsTemp = new int[26];//初始值是0
            //此循环之后，可以统计出字符串中每个字符出现的个数
            for (char c : content) {
                charsTemp[c - 'a']++;
            }
            //此循环后，将charsTemp字母数组和chars字母数组比较，
            // 每个字符出现少的更新的chars字母数组中
            for (int i = 0; i < 26; i++) {
                if (charsTemp[i] < chars[i]) {
                    chars[i] = charsTemp[i];
                }
            }//取小值

        }
        //循环取出，如果出现次数大于1 再多层循环
        for (int i = 0; i < chars.length; i++) {
            for (int k = 0; k < chars[i]; k++) {
                result.add((char) (i + 'a') + "");
            }
        }

        return result;

    }


}
