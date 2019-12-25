package com.qiwx.num;

//斐波那契
public class Fib {
    public static void main(String[] args) {

    }

    private static int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    //效率更高
    public int fib1(int N) {
        if (N < 2)
            return N;
        int[] m = new int[N + 1];
        m[0] = 0;
        m[1] = 1;
        for (int i = 2; i <= N; i++) {
            m[i] = m[i - 1] + m[i - 2];
        }
        return m[N];
    }
}
