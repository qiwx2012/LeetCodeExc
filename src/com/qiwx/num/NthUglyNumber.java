package com.qiwx.num;

//丑数 II
public class NthUglyNumber {
    public static void main(String[] args) {
        nthUglyNumber(30);
    }

    //常规计算会超时
    private static int nthUglyNumber(int n) {
        int count = 1;
        int ugly = 1;
        int i = 2;
        while (count < n) {
            int num = ugly + 1;
            boolean isUgly = true;
            while (num > 1) {
                if (num % 2 == 0) {
                    num = num / 2;
                } else if (num % 3 == 0) {
                    num = num / 3;
                } else if (num % 5 == 0) {
                    num = num / 5;
                } else {
                    isUgly = false;
                    break;
                }
            }
            if (isUgly) {
                count++;
                System.out.println("===" + i);
            }
            ugly = i;
            i++;

        }
        return ugly;

    }

    //直接计算丑数，关键在于比较三个因数的顺序
    private static int nthUglyNumber1(int n) {
        int[] num = new int[n];
        num[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int[] result = new int[n];
        result[0] = 1;
        int begin = 1;
        int num2;
        int num3;
        int num5;
        while (begin < n) {
            //每次都取上次结果乘以对应的系数
            num2 = result[index2] * 2;//1*2 1*2*2 1*2*2*2
            num3 = result[index3] * 3;//1*3 1*3*3 1*3*3*3
            num5 = result[index5] * 5;//1*5 1*5*5 1*5*5*5
            //取三个数最小的数
            result[begin] = Math.min(num2, Math.min(num3, num5));
            if (result[begin] == num2) {
                index2++;
            }
            if (result[begin] == num3) {
                index3++;
            }
            if (result[begin] == num5) {
                index5++;
            }
            begin++;
        }
        return result[--begin];

    }
}
