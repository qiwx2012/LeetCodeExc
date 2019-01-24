package com.qiwx.num;

public class Solution {
    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
    public static int guessNumber(int n) {
        int l=1;
        int r=n;
        int mid=l+(r-l)/2;//避免（min+max）/2 会内存溢出
        while (l<=r){

            if(guess(mid)==1){
                l=mid+1;
                mid=l+(r-l)/2;

            }else if(guess(mid)==-1){
                r=mid-1;
                mid=l+(r-l)/2;
            }else{
                return mid;
            }
        }
        return 1;
    }
    private static int guess(int key){
        if(6>key){
            return 1;
        }else if(6<key){
            return -1;
        }else {
            return 0;
        }

    }
}
