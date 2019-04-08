package com.qiwx.array;
//二分查找
public class Search {
    public static void main(String[] args) {
       System.out.println(search(new int[]{-1,0,3,5,9,12},13));
    }
    public static int search(int[] nums, int target) {
        int left=0;
        int right=nums.length;
        int mid=left+(right-left)/2;
        while (left<right){
            if(nums[mid]>target){
                right=mid;
            }else if(nums[mid]<target){
                if(mid<right)
                 left=mid+1;
            }else {
                return mid;
            }
            mid=left+(right-left)/2;
        }
        return -1;

    }
}
