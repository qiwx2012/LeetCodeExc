package com.qiwx.num;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

//完美数
public class CheckPerfectNumber {
    public static void main(String[] args) {
        // System.out.println(checkPerfectNumber(99999992));
        System.out.println(checkPerfectNumber1(6));
    }

    public static boolean checkPerfectNumber1(int num) {
        //1和2是完美数
        if (num == 1)
            return false;
        int i, sum = 1;
        double len = Math.sqrt(num);
        for (i = 2; i < len; i++) {
            if (num % i == 0) {//折半利用余数满足条件的相加
                sum = sum + i + num / i;
                if (sum > num)
                    return false;
            }
        }
        return sum == num;

    }

    public static boolean checkPerfectNumber(int num) {
        //1和2是完美数
        if (num <= 2)
            return false;
        int sum = 1;
        int left = 2;
        int right = num - 1;
        while (left < right) {
            if (left * right > num) {
                right--;
            } else if (left * right < num) {
                left++;
            } else {
                sum = sum + left + right;
                if (sum > num) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return sum == num;

    }
}
