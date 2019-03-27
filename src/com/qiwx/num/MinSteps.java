package com.qiwx.num;

import java.util.LinkedList;
import java.util.List;

//只有两个键的键盘
public class MinSteps {
    public static void main(String[] args) {
      //  System.out.println(minSteps(6));
        System.out.println(minSteps(4));
        System.out.println(minSteps(22));
    }
    public static int minSteps(int n) {
        //此题核心是查找一个数有几个公因数
        if(n==1)
            return 0;
        if(n==2)
            return 2;//c1 v1
        if(n==3)
            return 3;//c1 v2
        //为了尽量少的操作，因该尽量多的复制
        int mid=n/2;
         int maxfactor=1;
       for(int i=2;i<=mid;i++){
             if(n%i==0){
                 maxfactor=i;//最小公因子
                 break;
             }
       }
       if(maxfactor==1){
           return n;
       }
       return maxfactor+minSteps(n/maxfactor);
    }
}
