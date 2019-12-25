package com.qiwx.array;

import java.util.Arrays;

//山脉数组的峰顶索引
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        peakIndexInMountainArray(new int[]{0, 2, 1, 0});
    }

    public static int peakIndexInMountainArray(int[] A) {
        int len = A.length;
        int left = 0;
        int right = len - 2;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (A[mid] < A[mid + 1]) {
                left = mid + 1;
            } else if (A[mid] > A[mid + 1]) {
                right = mid;
            }
        }
        return left;

    }

    public static int peakIndexInMountainArray1(int[] A) {
        int len = A.length;
        for (int i = 1; i < len - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                return i;
            }
        }
        return 0;
    }
}
