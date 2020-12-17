package com.qiwx.month_09;

/**
 * @description
 * @Author qiwx
 * @Date 2020-09-28 16:22
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 **/
public class Exc1 {
    public static void main(String[] args) {

       System.out.println(new Exc1().isUnique("leetcode"));
    }

    public boolean isUnique(String astr) {
        if (astr == null || astr.length() == 1)
            return true;

        for (int i = 0; i < astr.length(); i++) {
            if (astr.indexOf(astr.charAt(i), i + 1) > 0) {
                return false;
            }

        }
        return true;

    }

    //效率不高
    public boolean isUnique1(String astr) {
        boolean isUnique = true;
        if (astr == null || astr.length() == 1)
            return isUnique;
        while (astr.length() > 0) {
            char key = astr.charAt(0);
            astr = astr.replaceFirst(key + "", "");

            if (astr.contains(key + "")) {
                isUnique = false;
                break;
            }

        }
        return isUnique;

    }
}
