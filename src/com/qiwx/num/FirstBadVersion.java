package com.qiwx.num;

//第一个错误的版本
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        return firstBadVersion(1, n);
    }

    public int firstBadVersion(int start, int end) {
        if (start == end)
            return end;
        int mid = start + (end - start) / 2;
        if (isBadVersion(mid)) {
            //错误版本继续向前查找
            return firstBadVersion(start, mid);
        } else {
            //正确版本继续向后找
            return firstBadVersion(mid + 1, end);
        }
    }

    private boolean isBadVersion(int v) {
        return false;
    }
}
