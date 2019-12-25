package com.qiwx.num;

import java.util.LinkedList;
import java.util.List;

//自除数
public class SelfDividingNumbers {
    public static void main(String[] args) {
        selfDividingNumbers(1, 22);
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (i <= 9) {
                list.add(i);
            } else {
                int temp = i;
                boolean isdivid = true;
                while (temp > 0) {
                    int x = temp % 10;
                    if (x == 0 || i % x != 0) {
                        isdivid = false;
                        break;
                    }
                    temp = temp / 10;
                }
                if (isdivid) {
                    list.add(i);
                }
            }
        }

        return list;
    }
}
