package com.qiwx.num;

//2的幂
public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo1(-2147483648));
    }

    public static boolean isPowerOfTwo1(int n) {
        if (n <= 0)
            return false;
        //因为2的幂二进制 1,2,4,8都是这种结构 1 10 100 1000 10000
        //那么n-1 0,1,3,7的结构是0 1 11 111 1111
        //利用位运算& 两个数与后是否为0来判断n是否是2的幂次方
        return (n & (n - 1)) == 0;

    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }
}
