package com.qiwx.array;

//最小差值
public class SmallestRangeI {
    public static void main(String[] args) {
        System.out.println(smallestRangeI(new int[]{2, 7, 2}, 1));
        System.out.println(smallestRangeI(new int[]{0, 10}, 2));
        System.out.println(smallestRangeI(new int[]{1, 3, 6}, 3));
    }

    private static int smallestRangeI(int[] A, int K) {
        int len = A.length;
        if (len == 1)
            return 0;
        int min = 10000;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] < min) {
                min = A[i];
            }
            if (A[i] > max) {
                max = A[i];
            }
        }
        int gap = max - min;
        //先把最大值和最小值求出来，然后根据K的取值范围
        //大的变小 小的变大所以差值在2K之间可以通过x将差值缩小为0；
        if (gap <= 2 * K) {
            return 0;
        } else {

            return gap - 2 * K;
        }

    }
}
