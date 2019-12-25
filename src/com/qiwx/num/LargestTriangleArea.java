package com.qiwx.num;

//最大三角形面积
public class LargestTriangleArea {
    public static void main(String[] args) {
        System.out.println(largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}));
    }

    public static double largestTriangleArea(int[][] points) {
        //已知三个坐标，求三角形面积
        // (x1-x0)*(y2-y0)-(x2-x0)*(y1-y0)化简的
        //S=(x1y2+x2y3+x3y1-x1y3-x2y1-x3y2)/2;
        //平行四边形面积等于2S，
        double area = 0;
        for (int[] a : points) {
            for (int[] b : points) {
                for (int[] c : points) {
                    area = Math.max(area, 0.5 * Math.abs(a[0] * b[1] + b[0] * c[1] + c[0] * a[1] - a[0] * c[1] - b[0] * a[1] - c[0] * b[1]));
                }
            }
        }
        return area;

    }
}
