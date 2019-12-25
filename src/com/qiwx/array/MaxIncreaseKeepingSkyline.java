package com.qiwx.array;

//807 保持城市天际线
public class MaxIncreaseKeepingSkyline {
    public static void main(String[] args) {
        System.out.println(maxIncreaseKeepingSkyline(new int[][]{{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}}));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        //理解题意，新数组中每个值都要满足以下条件
        // 小于每列最高值和每行最高值的的最大值
        int[] maxx = new int[grid.length];
        int[] maxy = new int[grid[0].length];
        //计算横向最大值
        maxx[0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (maxx[i] < grid[j][i]) {
                    maxx[i] = grid[j][i];
                }
            }
        }
        //先计算纵向最大值
        maxy[0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (maxy[i] < grid[i][j]) {
                    maxy[i] = grid[i][j];
                }
            }
        }

        int num = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                int target = Math.min(maxx[j], maxy[i]);
                if (grid[i][j] < target) {
                    num += target - grid[i][j];
                }
            }
        }

        return num;

    }

}
