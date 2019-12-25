package com.qiwx.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//解数独
public class SolveSudoku {
    static Map<Integer, Set<Character>> box = new HashMap<>();//最小九宫格
    static Map<Integer, Set<Character>> lines = new HashMap<>();//所在行数字
    static Map<Integer, Set<Character>> cloumns = new HashMap<>();//所在列

    public static void main(String[] args) {
        String l1 = "53..7....";
        String l2 = "6..195...";
        String l3 = ".98....6.";
        String l4 = "8...6...3";
        String l5 = "4..8.3..1";
        String l6 = "7...2...6";
        String l7 = ".6....28.";
        String l8 = "...419..5";
        String l9 = "....8..79";
        String[] str = new String[9];
        str[0] = l1;
        str[1] = l2;
        str[2] = l3;
        str[3] = l4;
        str[4] = l5;
        str[5] = l6;
        str[6] = l7;
        str[7] = l8;
        str[8] = l9;
        char[][] arrays = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arrays[i][j] = str[i].toCharArray()[j];
            }
        }
        new SolveSudoku().solveSudoku(arrays);
        System.out.println('1' - '0' + 3);


    }

    int n = 3;
    int N = n * n;
    int[][] rows = new int[N][N + 1];
    int[][] columns = new int[N][N + 1];
    int[][] boxes = new int[N][N + 1];
    char[][] board;
    boolean sudokuSolved = false;

    public boolean couldPlace(int d, int row, int col) {
        int idx = (row / n) * n + col / n;
        return rows[row][d] + columns[col][d] + boxes[idx][d] == 0;
    }

    public void placeNumber(int d, int row, int col) {
        int idx = (row / n) * n + col / n;
        rows[row][d]++;
        columns[col][d]++;
        boxes[idx][d]++;
        board[row][col] = (char) (d + '0');
    }

    public void removeNumber(int d, int row, int col) {
        int idx = (row / n) * n + col / n;
        rows[row][d]--;
        columns[col][d]--;
        boxes[idx][d]--;
        board[row][col] = '.';

    }

    public void placeNextNumbers(int row, int col) {
        if ((col == N - 1) && (row == N - 1)) {
            sudokuSolved = true;
        } else {
            if (col == N - 1) {
                backtrack(row + 1, 0);
            } else {
                backtrack(row, col + 1);
            }
        }
    }

    public void backtrack(int row, int col) {
        if (board[row][col] == '.') {
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumbers(row, col);
                    if (!sudokuSolved) {
                        removeNumber(d, row, col);
                    }
                }
            }
        } else {
            placeNextNumbers(row, col);
        }

    }

    public void solveSudoku(char[][] board) {
        //box size
        this.board = board;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = Character.getNumericValue(num);
                    placeNumber(d, i, j);
                }
            }
        }
        backtrack(0, 0);


    }
//    public static void solveSudoku(char[][] board) {
//
//        for(int row=0;row<9;row++){
//            for(int column=0;column<9;column++){
//                if(board[row][column]=='.'){
//
//                }else {
//                    //方块索引
//                    int boxIndex=row/3*3+column/3;
//                    Set<Character> sets=box.get(boxIndex);
//                    if(sets==null){
//                        sets=new HashSet<>();
//                    }
//                    sets.add(board[row][column]);
//                    box.put(boxIndex,sets);
//                    //行索引
//                    Set<Character> lineSets=lines.get(row);
//                    if(lineSets==null){
//                        lineSets=new HashSet<>();
//                    }
//                    lineSets.add(board[row][column]);
//                    lines.put(row,lineSets);
//                    //列索引
//                    Set<Character> columnSets=cloumns.get(column);
//                    if(columnSets==null){
//                        columnSets=new HashSet<>();
//                    }
//                    columnSets.add(board[row][column]);
//                    cloumns.put(row,columnSets);
//                }
//            }
//        }
//        for(int row=0;row<9;row++)
//        {
//            for(int column=0;column<9;column++){
//                if(board[row][column]=='.'){
//
//                }
//            }
//        }
//
//    }
    //回溯函数

    //判断是否是合法的数
    public static boolean isValidNum(int num, int row, int column) {
        int boxIndex = row / 3 * 3 + column / 3;
        char value = (char) (num + '0');
        if (box.get(boxIndex).contains(value) || lines.get(row).contains(value) || cloumns.get(column).contains(value)) {
            return false;
        }
        return true;
    }
}
