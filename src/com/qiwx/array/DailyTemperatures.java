package com.qiwx.array;

import java.util.LinkedList;
import java.util.List;

//每日温度
public class DailyTemperatures {
    public static void main(String[] args) {
        dailyTemperatures1(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    public static int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (T[i] < T[j]) {
                    result[i] = j - i;
                    break;
                } else if (j == len - 1) {
                    result[i] = 0;
                }
            }
        }
        result[len - 1] = 0;
        return result;
    }

    public static int[] dailyTemperatures1(int[] T) {
        int[] res = new int[T.length];
        res[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < T.length; j += res[j]) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;

    }
}
