package com.qiwx.array;

// 到最近的人的最大距离
public class MaxDistToClosest {
    public static void main(String[] args) {
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0, 1, 0, 1}));
        System.out.println(maxDistToClosest(new int[]{1, 0, 0, 0}));
        System.out.println(maxDistToClosest(new int[]{0, 1, 0, 0, 0, 0}));
        System.out.println(maxDistToClosest(new int[]{0, 0, 1}));
    }

    private static int maxDistToClosest(int[] seats) {
        //最近人的最近距离，如果有两个人那么最近人的最短距离里为
        //两个人之间距离的二分之一，如果只有一个人那么就是两人之间的距离
        //根据1的数量确认是否除以2
        int oneNum = 0;//1的数量
        int setps = 0;
        int maxdistance = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                setps++;
            } else {
                oneNum++;
                if (oneNum == 1) {
                    if (setps > 0) {
                        maxdistance = maxdistance > setps ? maxdistance : setps;
                        setps = 0;
                    }
                } else if (oneNum == 2) {
                    int x = setps / oneNum;
                    if (setps % 2 != 0) {
                        x++;
                    }
                    maxdistance = x > maxdistance ? x : maxdistance;
                    setps = 0;
                    oneNum = 1;
                }

            }
        }
        if (setps > 0) {
            int x = setps / oneNum;
            maxdistance = x > maxdistance ? x : maxdistance;
        }
        return maxdistance;

    }
}
