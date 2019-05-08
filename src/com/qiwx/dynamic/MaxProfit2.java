package com.qiwx.dynamic;
//买卖股票的最佳时机 II
public class MaxProfit2 {
    public static void main(String[] args) {
    }
    public static int maxProfit(int[] prices) {
        int len=prices.length;
        int max=0;
        for(int i=0;i<len-1;i++){
            if(prices[i]<prices[i+1]){
                max=max+prices[i+1]-prices[i];
            }

        }
        return max;
    }
}
