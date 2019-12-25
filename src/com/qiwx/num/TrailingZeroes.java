package com.qiwx.num;

import java.util.LinkedList;
import java.util.List;

//172. 阶乘后的零
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(1808548329));
        System.out.println(trailingZeroes(90));
        System.out.println(trailingZeroes(5));
    }

    public static int trailingZeroes(int n) {
        int num = 0;
        LinkedList<Integer> data2 = new LinkedList<>();
        LinkedList<Integer> data5 = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            //只有2，4，5，8乘积才有可能为0
            int x = i;
            while (x % 2 == 0) {
                data2.add(2);
                x = x / 2;
            }
            while (x % 5 == 0) {
                data5.add(5);
                x = x / 5;
            }
            while (!data2.isEmpty() && !data5.isEmpty()) {
                data2.pop();
                data5.pop();
                num++;
            }
        }
        return num;
    }

    //阶乘后的零的个数要看阶乘可分解的数字5的数量
    public static int trailingZeroes2(int n) {
        int ans = 0, k = n;
        while (k > 1) {
            k /= 5;
            ans += k;
        }
        return ans;
    }
}
