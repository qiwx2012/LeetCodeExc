package com.qiwx.num;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//计数质数
public class CountPrimes {
    public static void main(String[] args) {
      System.out.println(countPrimes(10));
     // System.out.println(countPrimes(499979));
    }
    private static int countPrimes(int n){
        if (n <= 1) {
            return 0;
        }
        //默认为false
        boolean[] isPrime=new boolean[n];
        isPrime[0]=true;
        isPrime[1]=true;
        for (int i=2;i*i<n;i++){
            if (!isPrime[i]) {
                for (int j = i * 2; j < n; j += i) {
                    isPrime[j] = true;
                }
            }
        }

        //统计质数个数
        int result=0;
        for (boolean b:isPrime){
            if (!b){
                result++;
            }
        }

        return result;
    }
}
