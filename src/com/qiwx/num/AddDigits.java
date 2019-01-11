package com.qiwx.num;
//各位相加
public class AddDigits {
    public static void main(String[] args) {
        addDigits(38);
    }

    //有个一种一行代码搞定的 (num-1)%9+1;数学原理清楚余9法
    public static int addDigits(int num) {
        if(num/10==0)
            return num;
        int temp=0;
        while (num!=0){
            temp+=num%10;
            num=num/10;
        }
        num=addDigits(temp);
        return num;

    }

}
