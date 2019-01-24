package com.qiwx.num;

import java.util.*;

public class KClosest {
    public static void main(String[] args) {

    }
    public static int[][] kClosest(int[][] points, int K) {
        Map<Integer, List<int[]>> map=new HashMap<>();
        int[] tmp = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int x = point[0];
            int y = point[1];
            tmp[i] = x * x + y * y;
            if (map.get(tmp[i]) == null) {
                List<int[]> list = new ArrayList<>();
                list.add(point);
                map.put(tmp[i], list);
            } else {
                List<int[]> ints = map.get(tmp[i]);
                ints.add(point);
                map.put(tmp[i], ints);
            }
        }
        Arrays.sort(tmp);
        int[][] r = new int[K][2];
        int sum = 0;
        for (int i = 0; i < K; i++) {
            List<int[]> ints = map.get(tmp[i]);
            int count = 0;
            while (count < ints.size()) {
                r[sum] = ints.get(count++);
                sum++;
            }
        }
        return r;
    }
}
