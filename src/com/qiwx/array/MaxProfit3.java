package com.qiwx.array;

import java.util.Stack;

//买卖股票的最佳时机 III
public class MaxProfit3 {
    public static void main(String[] args) {
        //maxProfit(new int[]{3,3,5,0,0,3,1,4});
       // maxProfit(new int[]{1,4,2});
        maxProfit(new int[]{2,1,4});
       // maxProfit(new int[]{1,2,3,4,5});
        //maxProfit(new int[]{7,6,4,2,1});
       // maxProfit(new int[]{1,3,5,4,3,7,6,9,2,4});
        //maxProfit(new int[]{1,2,3,4,5});
    }
    public static int maxProfit(int[] prices) {
        int max=0;
        int len=prices.length;
        if(len==0)
            return 0;
        int bottom=prices[0];
        int[] prices1=new int[len+1];
        System.arraycopy(prices,0,prices1,0,len);
        prices1[len]=-1;
        int top=-1;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<len;i++){
              if(prices1[i]<=prices1[i+1]){
                  //下行趋势只记录谷底
                  bottom=prices1[i];
              }else{
                 stack.push(prices1[i]-bottom);
              }
        }
        if(top>=0&&bottom>=0){
            stack.push(top-bottom);

        }else if(top<0){
            if(stack.size()<=0){
                //说明死线性递增
                stack.push(prices[len-1]-prices[0]);
            }else{
                if(prices[len-1]>bottom){
                    stack.push(prices[len-1]-bottom);
                }

            }

        }else if(bottom<0){
            stack.clear();
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
