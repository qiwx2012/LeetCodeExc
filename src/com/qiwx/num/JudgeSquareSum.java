package com.qiwx.num;

//平方数之和
public class JudgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(1000));
        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum(25));
        System.out.println(judgeSquareSum(34));
        System.out.println(judgeSquareSum(1));
        System.out.println(judgeSquareSum(0));
    }

    public static boolean judgeSquareSum(int c) {
        int size = (int) Math.sqrt(c);
        int i = 0;
        while (i <= size) {
            if (i * i + size * size < c) {
                i++;
            } else if (i * i + size * size > c) {
                size--;
            } else {
                System.out.println(i + "---" + size);
                return true;
            }
        }

        return false;

    }

}
