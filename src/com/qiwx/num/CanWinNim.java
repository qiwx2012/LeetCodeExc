package com.qiwx.num;

//Nim游戏
public class CanWinNim {
    public static void main(String[] args) {
        System.out.println(canWinNim(1348820612));
    }

    public static boolean canWinNim(int n) {
        //巴什博奕，n%(m+1)!=0时，先手总是会赢的
        return n % (4) != 0;
    }
}
