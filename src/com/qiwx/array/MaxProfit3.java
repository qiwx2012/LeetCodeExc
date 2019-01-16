package com.qiwx.array;

import java.util.Stack;

//买卖股票的最佳时机 III
public class MaxProfit3 {
    public static void main(String[] args) {
        //maxProfit(new int[]{3,3,5,0,0,3,1,4});
       // maxProfit(new int[]{1,4,2});
       // maxProfit(new int[]{2,1,4});
       // maxProfit(new int[]{1,2,3,4,5});
        //maxProfit(new int[]{7,6,4,2,1});
        maxProfit(new int[]{1,2,4,2,5,7,2,4,9,0});
       // maxProfit(new int[]{1,3,5,4,3,7,6,9,2,4});
        //maxProfit(new int[]{1,2,3,4,5});
    }
    public static int maxProfit(int[] prices) {
        int max=0;
        int len=prices.length;
        if(len==0)
            return 0;
        int buy=prices[0];
        int sell=-1;
        Stack<Integer> stack=new Stack<>();
        for(int i=1;i<len;i++){
            if(prices[i]>prices[i-1]){
                sell=prices[i];
                if(i==len-1){
                    stack.push(sell-buy);
                }
            }else{
                if(buy>=0&&sell>=0){
                   int a=sell-buy;
                   stack.push(a);
                   buy=prices[i];
                   sell=-1;
                }else{
                    buy=prices[i];
                }

            }
        }
        if(stack.size()==0){
            return 0;
        }else if(stack.size()==1){
            return stack.pop();
        }else if(stack.size()==2){
            return stack.elementAt(0)+stack.elementAt(1);
        }else {
            int index=-1;
            int mm=-1;
            int size=0;
            while (size<2){
                for(int i=0;i<stack.size();i++){
                    if(mm<=stack.elementAt(i)){
                        mm=stack.elementAt(i);
                        index=i;
                    }
                }
                max+=mm;
                mm=-1;
                stack.remove(index);
                size++;

            }
            return max;
        }
    }
}
