package com.qiwx.num;

//有效的完全平方数
public class IsPerfectSquare {
    public static void main(String[] args) {
        //System.out.println(isPerfectSquare(0));
        System.out.println(isPerfectSquare(
                2147395600));
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
        System.out.println(isPerfectSquare(25));
        System.out.println(isPerfectSquare(100));
    }

    private static boolean isPerfectSquare(int num) {
        if (num <= 0)
            return false;
        if (num == 1)
            return true;
        long l = 1, r = num / 2;
        long mid, midSq;
        while (l <= r) {
            mid = (l + r) / 2;
            midSq = mid * mid;
            if (midSq == num) return true;
            if (midSq < num) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}
