package com.qiwx.num;
//坏了的计算器
public class BrokenCalc {
    public static void main(String[] args) {
       System.out.println(brokenCalc(3,8));
    }
    public static int brokenCalc(int X, int Y) {
        int count = 0;
        if(Y==X) return 0;
        else if(Y < X)  return X-Y;
        else{
            while(Y > X) {
                count++;
                if(Y%2==1) Y++;
                else Y/=2;
            }
            count = X-Y+count;
        }
        return count;


    }
}
