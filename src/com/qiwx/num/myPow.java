package com.qiwx.num;

public class myPow {
    public static void main(String[] args) {
     System.out.println(myPow1(2.0,10));
     //System.out.println(myPow(2.1,3));
     System.out.println(myPow(2.0,-2));
    }
    //此方法会超出时间限制
    public static double myPow(double x,int n){
        boolean isDivide=n>0?false:true;
        double result=1;
        n=Math.abs(n);
        while (n!=0){
            result*=x;
            n--;
        }
        return  isDivide?1/result:result;
    }
    public static double myPow1(double x,int n){
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
            //2的10次方等价于 4的5次方
            //4的5次方等价于 16的2次方乘以4的一次方
            //256*4
        }
        return  n < 0 ? 1 / res : res;

    }

}
