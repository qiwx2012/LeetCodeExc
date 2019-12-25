package com.qiwx.array;

//腐烂的橘子
public class OrangesRotting {
    public static void main(String[] args) {

    }

    public static int orangesRotting(int[][] grid) {
        //因为坏橘子是向四周扩散，取方格最大的边作为
        //循环次数n，如果n分钟后还有好橘子那么就返回0
        int x = grid.length;
        int y = grid[0].length;
        int size = x > y ? x : y;
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (grid[i][j] == 2) {
                        if (i == 0 && y == 0) {

                        }
                    }

                }
            }
        }

        return 0;
    }
}
