package com.qiwx.array;

import java.util.Stack;

//买卖股票的最佳时机
public class MaxProfit {
    public static void main(String[] args) {
       // maxProfit(new int[]{7,1,5,3,6,4});
        //maxProfit(new int[]{7,6,5,4,2,1});
        //maxProfit(new int[]{2,4,1});
        //maxProfit(new int[]{1,2});
        maxProfit(new int[]{1,2,4});
    }
    //动态规划算法
    private static int maxProfit1(int[] prices){
        if (prices.length == 0) return 0;
        int temp = 0;
        int max = 0;
        for(int i=1;i < prices.length;i++) {
            temp = (prices[i] + temp - prices[i-1]) > 0 ? (prices[i] + temp - prices[i-1]) : 0;
            max = max < temp ? temp : max;
        }
        return max;
    }
    public static int maxProfit(int[] prices) {
        //类似波峰波谷的形状，先从波低开始买入，再波峰处卖掉
        //再从波底开始循环遍历完数组
        int len=prices.length;
        if(len<=1)
            return 0;
        if(len<=2){
            return prices[1]<prices[0]?0:prices[1]-prices[0];
        }
        Stack<Integer>stack= new Stack<>();
        stack.push(prices[0]);
        int max=0;
        for(int i=0;i<len-1;i++){
            if(prices[i]>prices[i+1]){
                if(stack.peek()>prices[i+1]){
                    stack.pop();
                    stack.push(prices[i+1]);
                }
            }else{
                for(int j=0;j<stack.size();j++){
                   int temp=prices[i+1]-stack.elementAt(j);
                   if(max<temp){
                       max=temp;
                   }
                }
            }
        }
        return max;

    }
}
