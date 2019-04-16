package com.qiwx.num;
//寻找两个有序数组的中位数
public class FindMedianSortedArrays {
    public static void main(String[] args) {
      System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len=nums1.length+ nums2.length;
        int left=0;
        int right=0;
        if(len%2!=0){
            int mid=len/2;
            int current=0;
            while (left+right<=mid){
                if(nums1[left]<=nums2[right]){
                    current= nums1[left];
                    left++;
                }else {
                    current= nums2[right];
                    right++;
                }
            }
            return current;

        }else {
            int[]mids=new int[2];
            while (mids[0]!=0&&mids[1]!=0){

            }

           return 1;
        }


    }
}
