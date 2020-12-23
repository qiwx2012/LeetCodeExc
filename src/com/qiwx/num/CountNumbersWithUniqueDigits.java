package com.qiwx.num;

/**
 * @description
 * @Author qiwx
 * @Date 2020-12-23 14:35
 * 计算各个位数不同的数字个数
 * 回溯算法
 **/
public class CountNumbersWithUniqueDigits {
    public static void main(String[] args) {

    }

    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int first = 10, second = 9 * 9;
        int size = Math.min(n, 10);
        for (int i = 2; i <= size; i++) {
            first += second;
            second *= 10 - i;
        }
        return first;

    }


}
