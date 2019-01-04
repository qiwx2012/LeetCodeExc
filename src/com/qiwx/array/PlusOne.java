package com.qiwx.array;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

//加1
public class PlusOne {
    public static void main(String[] args) {
      //plusOne(new int[]{9});
      plusOne(new int[]{9,8,7,6,5,4,3,2,1,3,4,5,6,7,8,4,3,3,3,4,5,3,3,3,3,9,3,3,3,3,9,3,3,9,9,9,9,9,9,9,0});
    }
   static long starttime=0;
   static long endtime;
    //最优方案
    private static int[] plusOne1(int[]digits){

        int len = digits.length;
        // 反向迭代
        for(int i = digits.length-1; i>=0; i--){
            if(digits[i]+1 == 10){       // 有进一就继续迭代
                digits[i] = 0;
            }else{                      // 否则退出循环
                digits[i]++;
                break;
            }
        }

        if(len == 0){       // 空数组的时候
            return new int[]{1};
        }else if(digits[0] == 0){       // 最高位也进一的时候，如果最高位是0一定是进位造成的
            int res[] = new int[len+1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, len);
            return res;
        }

        return digits;
    }
    public static int[] plusOne(int[] digits) {
        starttime=System.currentTimeMillis();
        int len=digits.length;
        for(int i=len-1;i>=0;i--){
            if(digits[i]+1==10){//等于10比大于10效率更快,
                digits[i]=0;
            }else{
                digits[i]++;
                break;
            }
        }
        int[] result=null;
        if(digits[0]==0){
           result=new int[digits.length+1];
           result[0]=1;
          System.arraycopy(digits,0,result,1,len);
        }else{
            result=digits;
        }
        System.out.println("用时"+(System.currentTimeMillis()-starttime));
       return result;

    }
}
