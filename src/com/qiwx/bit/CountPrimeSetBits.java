package com.qiwx.bit;

//二进制表示中质数个计算置位
public class CountPrimeSetBits {
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));
        System.out.println(countPrimeSetBits(10, 15));
    }

    public static int countPrimeSetBits(int L, int R) {
        //计算置位代表二进制中位数为1的个数，次题的意思就是找出置位数也是质数的个数

        //因为R,L最大值是1000000，找出32以内所有质数

        int result = 0;
        for (int i = L; i <= R; i++) {
            int num = i;
            int count = 0;
            while (num > 0) {
                if (num % 2 != 0) {
                    count++;
                }
                num = num >> 1;
            }
            if (count == 2
                    || count == 3
                    || count == 5
                    || count == 7
                    || count == 11
                    || count == 13
                    || count == 17
                    || count == 19
                    || count == 23
                    || count == 29
                    || count == 31
                    ) {
                result++;
            }
            count = 0;


        }
        return result;

    }
}
