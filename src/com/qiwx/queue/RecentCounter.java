package com.qiwx.queue;

import java.util.LinkedList;

//最近请求次数
public class RecentCounter {
    LinkedList<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.addLast(t);
        t = t - 3000;
        while (queue.getFirst() < t) {//如果是3000毫秒区间外的去掉
            queue.removeFirst();
        }
        return queue.size();
    }
}
