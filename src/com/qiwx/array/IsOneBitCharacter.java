package com.qiwx.array;

//1比特与2比特字符
public class IsOneBitCharacter {
    public static void main(String[] args) {
        isOneBitCharacter(new int[]{1, 0, 0});
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        boolean result = false;
        for (int i = 0; i < len; i++) {
            if (bits[i] == 0) {
                if (i + 1 == len) {
                    result = true;
                }
                continue;
            }
            if (bits[i] == 1) {
                i++;
            }

        }
        return result;

    }
}
