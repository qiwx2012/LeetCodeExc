package com.qiwx.array;

public class CanPlaceFlowers {
    public static void main(String[] args) {
         //canPlaceFlowers(new int[]{1,0,0,0,1,0,0},2);
         //canPlaceFlowers(new int[]{0},1);

         //System.out.println(canPlaceFlowers(new int[]{0,1,0},1));
         //System.out.println(canPlaceFlowers(new int[]{0},1));
         //System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1,0,0},2));
        // System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1,0,0},2));
         //System.out.println(canPlaceFlowers(new int[]{1,0,0,0,1},1));
        // System.out.println(canPlaceFlowers(new int[]{0,0,1,0,0},1));
         System.out.println(canPlaceFlowers(new int[]{1,0,0,0},1));
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0)
            return true;
        int len = flowerbed.length;
        if (len == 1) {
            if (flowerbed[0] == 1)
                return false;
            else {
                if (n <= 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < len; i++) {
            //遇到三个0可以种植一朵花
            if (i == 0 && flowerbed[i] == 0) {
                //第一个位置相当于左边默认是一个空位
                count = count + 2;
            } else if (flowerbed[i] == 0&&i==len-1) {
                //最后一个位置默认有一个空位
                count = count + 2;
            } else if (flowerbed[i] == 0) {
                count++;
            }else {
                count=0;
            }
            //count有可能会出现大于3的情况
            if (count >= 3) {
                flowerbed[i - 1] = 1;
                n--;
                i--;
                count = 0;
            }
            if(n==0){
                return true;
            }

        }

        return n == 0;
    }
}
