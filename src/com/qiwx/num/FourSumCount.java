package com.qiwx.num;

import java.util.HashMap;
import java.util.Map;

/**
 * @description
 * @Author qiwx
 * @Date 2020-12-17 13:49
 * 四数相加
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 **/
public class FourSumCount {
    public static void main(String[] args) {

    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int key = a + b;
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 1);
                }
            }
        }
        for (int c : C) {
            for (int d : D) {
                int key = c + d;
                if (map.containsKey(-key)) {
                    count += map.get(-key);
                }
            }
        }

        return count;

    }
}
