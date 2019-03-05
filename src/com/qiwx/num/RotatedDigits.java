package com.qiwx.num;

import java.util.HashMap;
import java.util.Map;

//旋转数字
public class RotatedDigits {
    public static void main(String[] args) {
       System.out.println(rotatedDigits(857));
    }
    public static int rotatedDigits(int N) {
        int count=0;
        for(int i=1;i<=N;i++){
            int m=i;
            boolean isGoodNum=false;
            while (m>0){
                int x=m%10;
                if(x==3||x==7||x==4){
                    isGoodNum=false;
                    break;
                }else {
                    //在有效数字的情况下，必须有一个数是2,5,6,9中
                    //的一个才可以保证数不相等
                    if(x!=0&&x!=1&&x!=8){
                        isGoodNum=true;
                    }
                }
                m=m/10;
            }
            if(isGoodNum){
                count++;
            }
        }
        return count;

    }
}
