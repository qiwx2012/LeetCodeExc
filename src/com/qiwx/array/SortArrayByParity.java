package com.qiwx.array;
//按奇偶排序数组 II
//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
public class SortArrayByParity {
    public static void main(String[] args) {
            System.out.println(sortArrayByParityII(new int[]{4,2,5,7}));
    }

    public static int[] sortArrayByParityIIBetter(int[] A) {
        int j = 1;
        //此算法更好的利用了条件
        for (int i = 0; i < A.length - 1; i = i + 2) {
            if ((A[i] & 1) != 0) {
                while ((A[j] & 1) != 0) {
                    j = j + 2;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }

    private static int[] sortArrayByParityII(int[] A) {
        int times=0;
        int max=A.length/2;
        for(int i=0;i<A.length;i++){
            //奇偶特性 奇数+奇数=偶数 偶数+偶数=偶数
            if(times>=max)
                break;
            if((i+A[i])%2!=0){
                for(int j=i+1;j<A.length;j++){
                    if((A[j]+i)%2==0){
                        int a=A[i];
                        A[i]=A[j];
                        A[j]=a;
                        times++;
                        break;
                    }
                }
            }
        }
        return A;
    }
}
