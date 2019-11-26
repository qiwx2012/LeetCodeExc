package com.qiwx.bit;

import java.util.ArrayList;
import java.util.List;

//格雷编码
public class GrayCode {
    public static void main(String[] args) {

    }
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));//新集合是旧集合高位补1得到的
            head <<= 1;
        }
        return res;
    }

}
