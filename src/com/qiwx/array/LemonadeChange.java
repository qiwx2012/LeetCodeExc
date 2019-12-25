package com.qiwx.array;

import java.util.HashMap;
import java.util.Map;

//柠檬水找零
public class LemonadeChange {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20}));
        System.out.println(lemonadeChange(new int[]{5, 5, 10}));
        System.out.println(lemonadeChange(new int[]{10, 10}));
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }

    public static boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> maps = new HashMap<>();
        int len = bills.length;
        for (int i = 0; i < len; i++) {
            if (bills[i] == 5) {
                int bill5 = maps.getOrDefault(5, 0);
                maps.put(5, bill5 + 1);
            } else if (bills[i] == 10) {
                int bill5 = maps.getOrDefault(5, 0);
                if (bill5 > 0) {
                    int bill10 = maps.getOrDefault(10, 0);
                    maps.put(10, bill10 + 1);
                    maps.put(5, bill5 - 1);
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                int bill5 = maps.getOrDefault(5, 0);
                int bill10 = maps.getOrDefault(10, 0);
                int x = 20;
                if (bill10 > 0) {
                    x = 10;
                    maps.put(10, bill10 - 1);
                }
                int size = x / 5;
                if (bill5 >= size - 1) {
                    //int bill20= maps.getOrDefault(20,0);
                    //maps.put(20,bill20+1);
                    maps.put(5, bill5 - size + 1);
                } else {
                    return false;
                }
            }
        }
//        for(Integer key : maps.keySet()){
//            int value = maps.getOrDefault(key,0);
//            count+=value;//不需要考虑面额，只要大于0就计入
//        }
        return true;
    }

    public static boolean lemonadeChange1(int[] bills) {
        int len = bills.length;
        int bill5 = 0;
        int bill10 = 0;
        for (int i = 0; i < len; i++) {
            if (bills[i] == 5) {
                bill5++;
            } else if (bills[i] == 10) {
                if (bill5 > 0) {
                    bill10++;
                    bill5--;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                int x = 20;
                if (bill10 > 0) {
                    x = 10;
                    bill10--;
                }
                int size = x / 5;
                if (bill5 >= size - 1) {
                    bill5 = bill5 - size + 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    //贪心算法
    public static boolean lemonadeChange2(int[] bills) {
        int len = bills.length;
        int bill5 = 0;
        int bill10 = 0;
        for (int i = 0; i < len; i++) {
            if (bills[i] == 5) {
                bill5++;
            } else if (bills[i] == 10) {
                if (bill5 > 0) {
                    bill10++;
                    bill5--;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                int x = 20;
                if (bill10 > 0) {
                    x = 10;
                    bill10--;
                }
                int size = x / 5;
                if (bill5 >= size - 1) {
                    bill5 = bill5 - size + 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
