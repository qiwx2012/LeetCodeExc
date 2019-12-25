package com.qiwx.dynamic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//不同路径
public class UniquePaths {
    public static void main(String[] args) {
      int count=new UniquePaths().uniquePaths(4,6);
      System.out.println(count+"===");
    }
    int m;
    int n;
    int count;

    public int uniquePaths(int m, int n) {
        this.m=m;
        this.n=n;
        isArrived(0,0);
        return count;
    }
    //是否到达
    private void isArrived(int x,int y){
        if(x==m-1&&y==n-1){
            count++;
        }
        if(x<m-1){
            isArrived(x+1,y);
        }
        if(y<n-1){
            isArrived(x,y+1);
        }
    }
    public int uniquePaths1(){
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
