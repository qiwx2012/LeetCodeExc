package com.qiwx.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//299. 猜数字游戏
public class GetHint {
    public static void main(String[] args) {
        // System.out.println(getHint("1807","7810"));
        //System.out.println(getHint("1123","0111"));
        System.out.println(getHint("11", "10"));
    }

    public static String getHint(String secret, String guess) {
        Map<Character, Integer> maps = new HashMap<>();
        Map<Character, Integer> maps2 = new HashMap<>();
        StringBuffer sb = new StringBuffer();
        int numA = 0;
        int numB = 0;
        for (int i = 0; i < secret.length(); i++) {
            Character c1 = secret.charAt(i);
            Character c2 = guess.charAt(i);
            if (c1 == c2) {
                numA++;
            } else {
                maps.put(c1, maps.getOrDefault(c1, 0) + 1);
                maps2.put(c2, maps.getOrDefault(c1, 0) + 1);
            }
        }
        //TODO 此处判断maps中小值
        for (Character key : maps2.keySet()) {
            if (maps.containsKey(key)) {

            }

        }
        sb.append(numA + "A");
        sb.append(numB + "B");
        return sb.toString();


    }
}
