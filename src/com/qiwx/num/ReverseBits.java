package com.qiwx.num;

import java.util.LinkedList;

//190. 颠倒二进制位
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        int num = 0;
        //无符号运行会有问题
        while (n > 0) {
            if (n % 2 != 0) {
                list.add(1);
            } else {
                list.add(0);
            }
            n = n >> 1;
        }
        int pos = 0;
        while (!list.isEmpty()) {
            num += list.pollLast() * (int) Math.pow(2, pos++);
        }
        return num;

    }

    public static int reverseBits1(int n) {
        int a = 0;
        for (int i = 0; i <= 31; i++) {
            //先取出最后一位，然后直接位运算到最高位
            a = a + ((1 & (n >> i)) << (31 - i));
        }
        return a;

    }

}
