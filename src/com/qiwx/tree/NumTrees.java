package com.qiwx.tree;

//不同的二叉树
public class NumTrees {
    public static void main(String[] args) {

    }

    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];

    }

    public int numTrees1(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];

    }

    public int addTree(int n, int index, int num) {
        int left = index;
        int right = n - index;
        if (left == 1 && right == n) {
            return num;
        } else if (left > 1) {
            addTree(n, left - 1, num + 1);
        } else {
            addTree(n, right - 1, num + 1);
        }
        return 0;
    }

}
