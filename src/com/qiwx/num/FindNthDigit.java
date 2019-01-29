package com.qiwx.num;
//第N个数字
public class FindNthDigit {
    public static void main(String[] args) {
      // System.out.println( findNthDigit(11));
     //  System.out.println( findNthDigit(3));
      // System.out.println( findNthDigit(1000030000));
       System.out.println( findNthDigit1(1000030000));
    }
    //此方法结果正确但会超时
    public static int findNthDigit(int n) {
        int index=1;
        if(n<10)
            return n;
        while (n>=0){
            String temp=String.valueOf(index);
            for(int i=0;i<temp.length();i++){
                n--;
                if(n==0){
                    return Integer.parseInt(""+temp.charAt(i));
                }
            }
            index++;
        }
        return -1;
    }
    public static int findNthDigit1(int n) {
        int len = 1, base = 1;
        while(n>9*base*len){
            n -= 9*base*len;
            len++;
            base *= 10;
        }
        int curNum = (n-1)/len + base, digit = 0;
        for(int i=(n-1)%len;i<len;++i){
            digit = curNum%10;
            curNum /= 10;
        }
        return digit;
    }
}
