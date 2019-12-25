package com.qiwx.num;

//位1的个数
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight(4));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            // n & (n-1) 清零最后一位1,二进制特性，相邻两个数
            //进行&操作，可以把最后一位1给去掉
            n = n & (n - 1);
        }
        return count;
    }
}
