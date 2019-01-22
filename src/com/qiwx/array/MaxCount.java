package com.qiwx.array;
//范围求和 II
public class MaxCount {
    public static void main(String[] args) {
        maxCount(3,3,new int[][]{{2,2},{3,3}});
    }
    public static int maxCount(int m, int n, int[][] ops) {

        int len=ops.length;
        if(len==0)
            return m*n;
        int minx=100000;
        int miny=100000;
        for(int i=0;i<len;i++){
            if(ops[i][0]<minx){
                  minx=ops[i][0];
            }
            if(ops[i][1]<miny){
                miny=ops[i][1];
            }
        }
        //根据题意只需要考虑最小覆盖面积的大小就是最大值
        return minx*miny;

    }
}
