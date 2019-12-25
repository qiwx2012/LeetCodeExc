package com.qiwx.num;

import java.util.Arrays;

//零钱兑换
public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 3, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 0;//0不需要硬币
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;//初始化为无穷大
            for (int j = 0; j < n; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE && dp[i - coins[j]] + 1 < dp[i]) {//选出最少的硬币数
                    dp[i] = dp[i - coins[j]] + 1;
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
