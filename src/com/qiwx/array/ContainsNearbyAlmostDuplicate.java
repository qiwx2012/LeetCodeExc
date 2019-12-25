package com.qiwx.array;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

//存在重复元素 III
public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        //System.out.println(containsNearbyAlmostDuplicate(new int[]{-1,2147483647},1, 2147483647));
        //System.out.println(containsNearbyAlmostDuplicate(new int[]{-3,3},2, 4));
        //System.out.println(containsNearbyAlmostDuplicate(new int[]{1},1, 1));
        System.out.println(containsNearbyAlmostDuplicate1(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        k = k > len ? len : k;
        long a, b, temp;
        int size;
        //双层循环
        for (int i = 0; i < len; i++) {
            size = k + i + 1 >= len ? len : k + i + 1;
            for (int j = i + 1; j < size; j++) {
                a = nums[i];
                b = nums[j];
                temp = Math.abs(a - b);
                if (temp <= t) {
                    return true;
                }


            }
        }
        return false;

    }

    //有序集合
    public static boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k <= 0 || t < 0) return false;
        if (t < 0) t = -t;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) ts.remove((long) nums[i - k - 1]);
            //每次检查新值是否在集合里，如果在那就符合条件
            NavigableSet<Long> tt = ts.subSet((long) nums[i] - t, true, (long) nums[i] + t, true);
            if (!tt.isEmpty()) return true;
            ts.add((long) nums[i]);
        }
        return false;
    }

    //https://blog.csdn.net/jmspan/article/details/51328581
    //版权声明：本文为博主原创文章，转载请附上博文链接！
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length <= 1 || k < 1 || t < 0) return false;
        long min = nums[0];
        for (int num : nums) min = Math.min(min, num);
        Map<Long, Long> buckets = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                long key = (nums[i - k - 1] - min) / ((long) t + 1);
                buckets.remove(key);
            }
            long key = (nums[i] - min) / ((long) t + 1);
            if (buckets.containsKey(key)) return true;
            Long small = buckets.get(key - 1);
            if (small != null && nums[i] - small <= t) return true;
            Long great = buckets.get(key + 1);
            if (great != null && great - nums[i] <= t) return true;
            buckets.put(key, (long) nums[i]);
        }
        return false;
    }

    //https://blog.csdn.net/jmspan/article/details/51328581
    //版权声明：本文为博主原创文章，转载请附上博文链接！
}
