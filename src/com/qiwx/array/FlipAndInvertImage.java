package com.qiwx.array;
//反转图像
public class FlipAndInvertImage {
    public static void main(String[] args) {
        System.out.println(flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}}));
    }
    public static int[][] flipAndInvertImage(int[][] A) {
        for(int i=0;i<A.length;i++){
            //一维数组
            int len=A[i].length;
            int right=len-1;
            int left=0;
            //水平反转
            while (left<right){
                if(A[i][left]!=A[i][right]){
                    int temp=A[i][left];
                    A[i][left]=A[i][right];
                    A[i][right]=temp;
                }
                left++;
                right--;
            }
            //反转图片
            for(int k=0;k<len;k++){
                //异或操作，不同为1 相同为0
                A[i][k]= A[i][k]^1;
            }
        }
        return A;
    }
}
