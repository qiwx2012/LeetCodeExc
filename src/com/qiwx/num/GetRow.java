package com.qiwx.num;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//杨辉三角1 杨辉三角2
public class GetRow {
    public static void main(String[] args) {
//        getRow1(4);
        generate(5);
    }

    public static List<Integer> getRow1(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(1);
        if (rowIndex == 0) {
            return result.subList(0, 1);
        } else if (rowIndex == 1) {
            return result;
        } else {
            //由于杨辉三角的特性，第rowIndex行的数组为rowIndex+1;
            while (result.size() <= rowIndex + 1) {
                int len = result.size();
                for (int i = 0; i < len - 1; i++) {
                    int addNum = result.get(i) + result.get(i + 1);
                    if (result.get(i + 1) != 1) {
                        result.set(i + 1, addNum);
                    }

                }
            }


        }
        return result;

    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(1);
        if (rowIndex == 0) {
            return result.subList(0, 1);
        } else if (rowIndex == 1) {
            return result;
        } else {
            int start = 2;
            while (start <= rowIndex) {
                List<Integer> temp = new ArrayList();
                int size = result.size();
                for (int i = size - 1; i > 0; i--) {
                    int addNum = result.get(i) + result.get(i - 1);
                    temp.add(addNum);
                }
                temp.add(0, 1);
                temp.add(1);
                start++;
                result.clear();
                result.addAll(temp);

            }
        }
        return result;

    }

    //给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new LinkedList<>();
        int[][] arrys = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            //杨辉三角可以看成二位数组,
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    arrys[i][j] = 1;//左边索引是0的位置始终是1
                } else if (j == i) {
                    arrys[i][j] = 1;//右边最后一个始终是1
                } else {
                    //其他情况，通用算法是 当前索引=前一行 相同索引
                    // 加上前一行 的前一个索引
                    arrys[i][j] = arrys[i - 1][j - 1] + arrys[i - 1][j];
                }
                temp.add(arrys[i][j]);
            }
            list.add(temp);

        }

        return list;
    }

}
