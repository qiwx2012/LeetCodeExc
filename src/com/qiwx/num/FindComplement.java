package com.qiwx.num;

public class FindComplement {
    public static void main(String[] args) {
        System.out.println(findComplement(5));
        System.out.println(findComplement(1));
    }
    private static int findComplement(int num){
        int result=0;
        int i=0;
        while (num>0)
        {
            //如果余数为0，说明此二进制数最后一位是0，
            //补数就是对其取反所以得1
            if(num%2==0){
                result+=Math.pow(2,i);
            }
            i++;
            num=num>>1;
        }
         return result;
    }
}
