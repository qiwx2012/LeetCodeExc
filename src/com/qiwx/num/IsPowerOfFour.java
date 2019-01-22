package com.qiwx.num;
//4的幂
public class IsPowerOfFour {
    public static void main(String[] args) {
        isPowerOfFour(5);
    }
    public static boolean isPowerOfFour(int num) {
        if(num==0)
            return false;
        while(num%4==0)
            num/=4;
        //最后剩下4除以4等于1 不等于1都不是4的幂
        return num==1;
    }
}
