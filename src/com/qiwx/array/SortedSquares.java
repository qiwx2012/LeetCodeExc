package com.qiwx.array;

//有序数组平方
public class SortedSquares {
    public static void main(String[] args) {
        sortedSquares(new int[]{-3, -3, -2, 1});
        //sortedSquares(new int[]{});
        sortedSquares(new int[]{1});
    }

    public static int[] sortedSquares(int[] A) {
        int len = A.length;
        if (len == 0)
            return A;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (Math.abs(A[i]) > Math.abs(A[j])) {
                    A[i] = A[i] ^ A[j];
                    A[j] = A[i] ^ A[j];
                    A[i] = A[i] ^ A[j];
                }
            }
            A[i] = A[i] * A[i];

        }
        A[len - 1] = A[len - 1] * A[len - 1];
        return A;

    }
}
