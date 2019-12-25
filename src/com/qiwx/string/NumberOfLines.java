package com.qiwx.string;

import java.util.HashMap;
import java.util.Map;

//写字符串需要的行数
public class NumberOfLines {
    public static void main(String[] args) {
        //numberOfLines(new int[]{3,3,4,5,6,7,8},"");
        numberOfLines(new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10}, "bbbcccdddaaa");
    }

    public static int[] numberOfLines(int[] widths, String S) {
        int[] result = new int[2];
        int len = S.length();
        int sum = 0;
        int line = 0;
        for (int i = 0; i < len; i++) {
            //char类型可进行算术运算
            int temp = widths[25 - ('z' - S.charAt(i))];
            if (sum + temp > 100) {
                sum = temp;
                line++;
            } else {
                sum += temp;
            }
        }
        result[1] = sum % 100;
        if (result[1] == 0)
            result[0] = line;
        else
            result[0] = line + 1;
        return result;
    }
}
