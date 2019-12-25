package com.qiwx.string;

import java.util.LinkedList;
import java.util.List;

//不含 AAA 或 BBB 的字符串
public class StrWithout3a3b {
    public static void main(String[] args) {
        //System.out.println(strWithout3a3b(2,5));
        System.out.println(strWithout3a3b(4, 1));
        System.out.println(strWithout3a3b(2, 3));
        System.out.println(strWithout3a3b(1, 2));
        System.out.println(strWithout3a3b(2, 2));
    }

    public static String strWithout3a3b(int A, int B) {
        StringBuffer sb = new StringBuffer();
        while (A > 0 && B > 0) {
            sb.append('a');
            sb.append('b');
            A--;
            B--;
        }
        if (A == 0 && B == 0) {
            return sb.toString();
        }
        if (A == 0) {
            sb.insert(0, 'b');
            B--;
            int index = 0;
            while (B > 0) {
                sb.insert(index, 'b');
                index += 3;
                B--;
            }
        } else {
            sb.append('a');
            A--;
            int index = 0;
            while (A > 0) {
                sb.insert(index, 'a');
                index += 3;
                A--;
            }
        }
        return sb.toString();
    }
}
