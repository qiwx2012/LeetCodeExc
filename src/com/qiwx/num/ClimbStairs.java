package com.qiwx.num;
//爬楼梯
public class ClimbStairs {
    public static void main(String[] args) {
    // System.out.println(climbStairs(4));
     //System.out.println(climbStairs(3));
     System.out.println(climbStairs(44));
    }
    private static int climbStairs(int n){
        if(n<=2)
            return n;
        int res = 0;
        int i=1,j=2;
        int k=3;
        while (k<=n){
            res=i+j;
            i=j;
            j=res;
            k++;   
        }
        return res;
    }
}
