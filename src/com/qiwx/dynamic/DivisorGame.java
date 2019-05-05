package com.qiwx.dynamic;
//除数博弈
public class DivisorGame {
    public static void main(String[] args) {


    }
    public static boolean divisorGame(int N) {
        //如果N为偶数，Alice可以选择1 让N变成奇数，这样bob无论如何操作 N最终都是奇数
        //这样N对于Alice始终是偶数，当N==2时 bob就会输
        //同理，如果N为奇数，bob可以采用同样当方法 Alice就会输
        return N%2==0;

    }
}
