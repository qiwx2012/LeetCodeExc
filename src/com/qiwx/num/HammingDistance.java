package com.qiwx.num;

//汉明距离
public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance(1, 3));
    }

    public static int hammingDistance(int x, int y) {
        int i = 0;
        long result = x ^ y;//异或运算，不同为1 相同为0，
        //判断每个位数上的数是0还是1
        long bit = 1;
        while (bit <= result) {
            if ((bit & result) != 0) {//两个数都为1则为1，否则为0
                i++;
            }
            bit = bit << 1;
        }
        return i;
    }
}
