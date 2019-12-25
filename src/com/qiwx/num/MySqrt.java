package com.qiwx.num;

//x的平方根
public class MySqrt {
    public static void main(String[] args) {
        // System.out.println(mySqrt(2147395600));
        //  System.out.println(mySqrt(4));
        //System.out.println(mySqrt(6));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(10));
    }

    private static int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1;
        int right = 46341; //int 最大值的平方根约等于46341
        int mid = 0;
        while (left < right) {
            if (mid == (left + right) / 2) {
                break;
            }
            mid = (left + right) / 2;
            int count = mid * mid;
            if (count == x) {
                break;
            } else if (count < x) {
                left = mid;
            } else {
                right = mid;
            }

        }
        return mid;
    }
}
