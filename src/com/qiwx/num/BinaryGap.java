package com.qiwx.num;

import java.util.HashMap;
import java.util.Map;

//二进制间距
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(binaryGap1(22));
        System.out.println(binaryGap1(8));
        System.out.println(binaryGap1(6));
        System.out.println(binaryGap1(5));
    }

    public static int binaryGap1(int N) {
        int maxGap = 0;
        int start = 0;
        while (N > 0) {
            if (N % 2 == 0) {
                if (start != 0) {
                    start++;
                }
                N = N >> 1;
            } else {
                if (start == 0) {
                    start++;
                    N = N >> 1;
                } else {
                    //如果第二次发现1，直接比较返回值，将大值付给maxGap，
                    //然后此种情况N值不变，继续进行下一轮
                    if (maxGap < start) {
                        maxGap = start;
                    }
                    start = 0;
                }
            }
        }
        return maxGap;

    }

    public static int binaryGap(int N) {
        int maxGap = 0;
        Map<Integer, Integer> maps = new HashMap<>();
        while (N > 0) {
            if (N % 2 != 0) {
                if (maps.isEmpty()) {
                    maps.put(1, 1);
                    N = N >> 1;
                } else {
                    //如果第二次发现1，直接比较返回值，将大值付给maxGap，
                    //然后此种情况N值不变，继续进行下一轮
                    if (maxGap < maps.get(1).intValue()) {
                        maxGap = maps.get(1).intValue();
                    }
                    maps.clear();
                }
            } else {
                if (!maps.isEmpty()) {
                    maps.put(1, maps.get(1).intValue() + 1);
                }
                N = N >> 1;
            }
        }
        return maxGap;

    }
}
