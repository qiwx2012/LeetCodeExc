package com.qiwx.array;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//子域名访问计数
public class SubdomainVisits {
    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> maps = new HashMap<>();
        int len = cpdomains.length;
        for (int i = 0; i < len; i++) {
            String[] temp = cpdomains[i].split(" ");
            int times = Integer.valueOf(temp[0]);
            //域名全程
            maps.put(temp[1], maps.getOrDefault(temp[1], 0) + times);
            //以此取出上级域名
            int start = 0;
            while (temp[1].indexOf(".", start) > 0) {
                int index = temp[1].indexOf(".", start);
                String tt = temp[1].substring(index + 1);
                maps.put(tt, maps.getOrDefault(tt, 0) + times);
                start = index + 1;
            }
        }
        List<String> result = new LinkedList<>();
        for (String s : maps.keySet()) {
            result.add(maps.get(s) + " " + s);
        }
        return result;

    }
}
