package com.qiwx.num;

public class HasAlternatingBits {
    public static void main(String[] args) {
        // System.out.println(5>>4);
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
        System.out.println(hasAlternatingBits(10));
        System.out.println(hasAlternatingBits(4));
    }

    public static boolean hasAlternatingBits(int n) {
        //相同则结果为0，不同则结果为1,
        // 此操作后如果符合要求，那么每位上都应该是1
        int temp = n ^ (n >> 1);
        //+1操作后 每位除了最高位是1 其他位数都是0 与操作
        //后值为0 返回true
        return (temp & (temp + 1)) == 0;

    }
}