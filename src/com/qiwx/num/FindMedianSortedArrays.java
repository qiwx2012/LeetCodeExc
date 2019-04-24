package com.qiwx.num;

//寻找两个有序数组的中位数
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            m = m ^ n;
            n = m ^ n;
            m = m ^ n;
        }
        int iMin = 0, iMax = m, haflen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = haflen - i;
            if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = iMin + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = iMax - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }

        }
        return 0.0;


    }
}
