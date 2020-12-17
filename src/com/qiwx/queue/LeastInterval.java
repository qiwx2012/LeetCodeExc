package com.qiwx.queue;

import java.util.*;

//任务调度器
public class LeastInterval {
    public static void main(String[] args) {
        new LeastInterval().leastInterval(new char[]{'A','A','A','A','B','B','B','B'},2);
    }
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;

    }
}
