package com.qiwx.array;

import java.util.Collections;

/**
 * @description
 * @Author qiwx
 * @Date 2020-12-16 16:56
 * 大数相加
 **/
public class MaxNumberAdd {

    public static void main(String[] args) {
//        System.out.println(add("123", "123"));
        System.out.println(test() + "");
        Exception exception;
        Error error;

    }

    private static int test() {

        int result = 10;
        try {
            System.out.println("ffffff");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            result = 20;
            return result;
        }
    }

    private static String add(String str1, String str2) {
        //将位数小的字符
        int len1 = str1.length();
        int len2 = str2.length();
        StringBuffer minSb = new StringBuffer();
        StringBuffer maxSb = new StringBuffer();
        StringBuffer result = new StringBuffer();
        if (len1 < len2) {
            minSb.append(str1);
            maxSb.append(str2);
        } else {
            minSb.append(str2);
            maxSb.append(str1);
        }
        //方便计算 位数对齐
        minSb.reverse();
        maxSb.reverse();
        int carry = 0;//进位

        for (int i = 0; i < minSb.length(); i++) {
            int sum = minSb.charAt(i) + maxSb.charAt(i) - 2 * '0' + carry;
            int a = sum % 10;
            carry = sum / 10;
            result.append(a);
        }
        for (int i = minSb.length(); i < maxSb.length(); i++) {
            int sum = maxSb.charAt(i) - '0' + carry;
            int a = sum % 10;
            carry = sum / 10;
            result.append(a);

        }
        //处理最后一个的进位(当循环结束后，是不是还可能会有一个进位)
        if (carry > 0)
            result.append(carry);
        return result.reverse().toString();


    }

}
