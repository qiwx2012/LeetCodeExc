package com.qiwx.array;

import java.util.Arrays;

//供暖器
public class FindRadius {
    public static void main(String[] args) {
       System.out.println(findRadius(new int[]{1,2,3},new int[]{2}));
       System.out.println(findRadius(new int[]{1},new int[]{1,2,3,4}));
       //System.out.println(findRadius(new int[]{1,2,3,4,5,6,7,8,9},new int[]{2,5}));
       System.out.println(findRadius(new int[]{1,5},new int[]{2}));
    }

    public int findRadius1(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int n = houses.length;
        int m = heaters.length;
        int minimum = 0;
        int j = 0;
        for(int i = 0 ;i< n ;i++){
            while( j < m - 1 && (Math.abs(heaters[j] - houses[i]) >= Math.abs(heaters[j+1] - houses[i])))
                j ++;
            //判断当前的房子离哪个加热器近，如果离左边的加热器比较近，更新最小半径为 以前的 和 这次中的较大的
            //如果离右边加热器比较近，遍历下一个加热器
            //如[1,2,3,4],[1,4]    1，2离1近，3，4离4近，距离差最大是1
            minimum = Math.max(minimum,Math.abs(heaters[j] - houses[i]));
        }
        return minimum;

    }




    public static int findRadius(int[] houses, int[] heaters) {
        int houseLen = houses.length;
        if (houseLen == 1)
            return 1;
        int heaterLen = heaters.length;
        int mid = 0;
        int left = houses[0];
        int right = houses[houseLen - 1];
        while (left <= right) {
            mid = left + (right - left) / 2;
            boolean ismin = true;
            for (int i = 0; i < heaterLen; i++) {
                if (i == 0) {
                    if (heaters[0] > mid) {
                        left = mid + 1;
                        ismin = false;
                        break;
                    }
                } else if (i == heaterLen - 1) {
                    if (houses[houseLen - 1] - heaters[heaterLen - 1] > mid) {
                        left = mid + 1;
                        ismin = false;
                        break;
                    }
                } else {
                    if (heaters[i] - heaters[i - 1] >= mid * 2) {
                        left = mid + 1;
                        ismin = false;
                        break;
                    }
                }
            }
            if (ismin) {
                right = mid - 1;
            }

        }

        return mid + 1;
    }

}
