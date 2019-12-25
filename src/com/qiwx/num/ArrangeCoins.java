package com.qiwx.num;

//排列硬币
public class ArrangeCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(5));
        System.out.println(arrangeCoins(8));
    }

    public static int arrangeCoins(int n) {
        int num = 0;
        if (n == 1)
            return 1;
        int index = 1;
        while (n - index > 0) {
            num++;
            n = n - index;
            index++;
        }
        return num;
    }

    //二分查找
    public static int arrangeCoins1(int n) {
        if (n == 0)
            return 0;
        long low = 1;
        long high = n;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sum = (mid + 1) * mid / 2;
            if (sum <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        //找到大于sum的临界值，行数就是low-1
        return (int) low - 1;
    }
}
