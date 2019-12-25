package com.qiwx.array;

//岛屿的周长
public class IslandPerimeter {
    public static void main(String[] args) {

    }

    private static int islandPerimeter(int[][] grid) {
        //根据题意，格子第一行和最后一行
        int x = grid[0].length;
        int y = grid.length;
        int sum = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (j == 0) {
                    if (grid[i][j] == 1) {
                        if (i == 0 || grid[i - 1][j] == 0) {
                            sum += 3;
                        } else {
                            sum += 2;
                        }
                    }
                } else {
                    if (grid[i][j] == 1) {
                        if (grid[i][j - 1] == 0) {
                            sum += 3;
                        } else {
                            sum += 2;
                        }
                    }
                }

            }
        }
        return 0;
    }
}
