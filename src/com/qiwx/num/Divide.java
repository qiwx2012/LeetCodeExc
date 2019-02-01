package com.qiwx.num;
//两数相除
public class Divide {
    public static void main(String[] args) {
         System.out.println(divide(-2147483648,-2147483648));
         System.out.println(divide(2147483647,2));
         System.out.println(divide(-2147483648,1));
         System.out.println(divide(10,3));
         System.out.println(divide(7,-3));
    }
    public static int divide(int dividend, int divisor) {
          int result=0;
        //当除数为最小值时
          if(dividend==Integer.MIN_VALUE){//-2147483648
              if(divisor==1){
                  return dividend;
              }else if(divisor==-1){
                  return Integer.MAX_VALUE;//2147483647
              }
          }
          //当除数为最大值时
        if(dividend==Integer.MAX_VALUE){
            if(divisor==1){
                return dividend;
            }else if(divisor==-1){
                return Integer.MIN_VALUE;
            }
        }
        if(dividend==divisor)
            return 1;
        //除数大于0,被除数小于0
        if(dividend>0&&divisor<0){
            while (dividend+divisor>=0){
                result--;
                dividend=dividend+divisor;
            }

        }else if(dividend>0&&divisor>0){
            //除数大于0,被除数大于0
            while (dividend-divisor>=0){
                result++;
                dividend=dividend-divisor;
            }
        }else if(dividend<0&&divisor<0){
            //除数小于0,被除数小于0
            while (dividend-divisor<=0){
                result++;
                dividend=dividend-divisor;
            }
        }else {
            //除数小于0,被除数大于0
            while (dividend+divisor<=0){
                result--;
                dividend=dividend+divisor;
            }
        }
          return result;

    }
    public static int divide1(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int num = 0;
        long sum;
        while (b <= a) {
            sum = b;
            int count = 1;
            while (sum + sum <= a) {
                count += count;
                sum += sum;
            }
            a = a - sum;
            num = num + count;
        }
        if ((dividend < 0 && divisor > 0) || dividend > 0 && divisor < 0) {
            num = -num;
        }
        return num;


    }
}
