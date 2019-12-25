package com.qiwx.array;

import java.util.HashMap;
import java.util.Map;

//机器人能否返回原点
public class JudgeCircle {
    public static void main(String[] args) {
        System.out.print(judgeCircle("UD"));
    }

    public static boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) {
            return true;
        }
        char[] steps = moves.toCharArray();
        int len = steps.length;
        int xPoint = 0;
        int yPoint = 0;
        for (int i = 0; i < len; i++) {
            char step = steps[i];
            switch (step) {
                case 'U':
                    yPoint++;
                    break;
                case 'D':
                    yPoint--;
                    break;
                case 'L':
                    xPoint--;
                    break;
                case 'R':
                    xPoint++;
                    break;
            }
        }
        return (xPoint == 0 && yPoint == 0);

    }

    private static boolean judgeCircle2(String moves) {
        if (moves == null) {
            return true;
        }
        char[] steps = moves.toCharArray();
        int len = steps.length;
        //为每种字符赋值,这么写不正确
        Map<Character, Integer> maps = new HashMap<>();
        maps.put('U', 1);
        maps.put('D', -1);
        maps.put('L', -1);
        maps.put('R', 1);
        int num = 0;
        for (int i = 0; i < len; i++) {
            num += maps.get(steps[i]);
        }
        return num == 0;
    }
}
