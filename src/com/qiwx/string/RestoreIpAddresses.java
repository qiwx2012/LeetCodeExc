package com.qiwx.string;

import java.util.LinkedList;
import java.util.List;

//复原IP地址
public class RestoreIpAddresses {
    public static void main(String[] args) {

    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        //根据ip地址规则，每位最小为1 最大为255
        helper(s, 0, "", result);
        return result;
    }

    public static void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.isEmpty()) res.add(out);
            return;
        }
        for (int k = 1; k < 4; ++k) {
            if (s.length() < k) break;
            int val = Integer.parseInt(s.substring(0, k));
            if (val > 255 || k != String.valueOf(val).length()) continue;
            helper(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), res);
        }
    }
}
