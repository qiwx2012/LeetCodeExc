package com.qiwx.test;

/**
 * @description
 * @Author qiwx
 * @Date 2020-09-27 18:03
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数。
 **/
public class MedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double Median=0;
        int m=nums1.length;
        int n=nums2.length;
        int[] num=new int[m+n];

        if(m==0&&n==0){
            return 0;
        }
        if(m==0){
            if(n%2==0){
                Median=((double)nums2[n/2-1]+(double)nums2[n/2])/2;
            }
            else
                Median=nums2[n/2];
        }
        if(n==0){
            if(m%2==0){
                Median=((double)nums1[m/2-1]+(double)nums1[m/2])/2;
            }
            else
                Median=nums1[m/2];
        }

        if(m!=0 && n!=0){
            for(int i=0,j=0,k=0;i<m+n;i++){
                if(j!=m && k!=n) {
                    if (nums1[j] < nums2[k]) {
                        num[i] = nums1[j];
                        j++;
                    } else {
                        num[i] = nums2[k];
                        k++;
                    }
                }

                if(j==m && k<n){
                    num[i+1]=nums2[k];
                    k++;
                }
                if(k==n && j<m){
                    num[i+1]=nums1[j];
                    j++;
                }
                if(j==m && k==n){
                    break;
                }
            }
            int length=m+n;
            if(length%2==0){
                length=(m+n)/2;
                Median=((double)num[length-1]+(double)num[length])/2;

            }
            else{
                length=length/2;
                Median=num[length];
            }
        }
        return Median;
    }
}
