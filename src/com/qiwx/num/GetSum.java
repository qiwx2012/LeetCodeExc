package com.qiwx.num;
//两个整数之和
public class GetSum {
    public static void main(String[] args) {

    }
// 1 对于二进制的两个数加在一起，若没有进行进位，只要a和b的i为相同，那么总和的i位就是0，也就是抑或操作
//2 若只进行进位，只要a和b的i-1位皆为1，总和的i位就为1，这就是位与操作后在进行位移操作
//3 递归重复上述步骤，找到没有进位结束。
    public int getSum(int a, int b) {
        if(b == 0) {
            return a;
        }
        int sum = a ^ b; //相加但不进位
        int carry = (a & b) << 1; //进位但不相加
        return getSum(sum, carry); //递归
    }
}
