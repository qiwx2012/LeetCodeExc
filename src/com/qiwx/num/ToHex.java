package com.qiwx.num;

//数字转换为十六进制数
public class ToHex {
    public static void main(String[] args) {

    }

    private static final char[] HEX_MAP = "0123456789abcdef".toCharArray();

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (; num != 0; num >>>= 4) {
            int x = num & 0b1111;//与运算 1111 保留后四位 因为二进制4位等于16进制一位
            sb.append(HEX_MAP[x]);
        }
        return sb.reverse().toString();
    }
}
