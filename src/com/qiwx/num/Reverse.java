package com.qiwx.num;

public class Reverse {
    public static void main(String[] args) {
        // System.out.println(reverse(1534236469));  ;
        System.out.println(reverse1(-123));
        ;
    }

    private static int reverse(int num) {
        int result = 0;
        boolean isFs = false;
        if (num < 0) {
            isFs = true;
            num = Math.abs(num);
        }
        //确定位数
        int i = 0;
        int s = num;
        while (s > 0) {
            i++;
            s = s / 10;
        }
        while (num > 0) {
            int a = num % 10;
            result += (int) a * Math.pow(10, --i);
            num = num / 10;

        }
        if (result >= Integer.MAX_VALUE || result <= Integer.MIN_VALUE)
            return 0;
        return isFs ? -result : result;

    }

    public static int reverse1(int x) {
        int rev = 0;
        while (x != 0) {
            //负数取余数仍是负数，不需要单独考虑符号问题
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            //每次将需要翻转的数乘以10，就是向前进一位 ，然后再加
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
