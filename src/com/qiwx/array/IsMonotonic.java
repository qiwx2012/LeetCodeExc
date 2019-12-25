package com.qiwx.array;

//单调数列
public class IsMonotonic {
    public static void main(String[] args) {
        //isMonotonic(new int[]{6,5,4,4,});
        //isMonotonic(new int[]{1,2,2,3,});
        System.out.println(isMonotonic(new int[]{5, 3, 2, 4, 1}));
    }

    public static boolean isMonotonic(int[] A) {
        int len = A.length;
        if (len <= 2)
            return true;
        String isBig = null;
        for (int i = 0; i < len - 1; i++) {
            if (A[i] == A[i + 1])
                continue;
            if (A[i] > A[i + 1]) {
                if (isBig == null) {
                    isBig = "true";
                } else {
                    if (!isBig.equals("true")) {
                        return false;
                    }
                }
            } else {
                if (isBig == null) {
                    isBig = "false";
                } else {
                    if (!isBig.equals("false")) {
                        return false;
                    }
                }
            }

        }
        return true;
    }
}
