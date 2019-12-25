package com.qiwx.string;

//学生出勤记录1
public class CheckRecord {
    public static void main(String[] args) {
        System.out.println(checkRecord("LALL"));
        System.out.println(checkRecord("PPALLL"));
    }

    private static boolean checkRecord(String s) {
        int absent = 0;//缺勤次数大于1不合格
        int late = 0;//迟到次数大于2不合格
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'A') {
                absent++;
                late = 0;
                if (absent > 1) {
                    return false;
                }
            } else if (chars[i] == 'L') {
                late++;
                if (late > 2) {
                    return false;
                }
            } else {
                late = 0;
            }
        }
        return true;
    }
}
