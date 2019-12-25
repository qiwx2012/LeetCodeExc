package com.qiwx.bit;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//子数组按位或操作
public class SubarrayBitwiseORs {
    public static void main(String[] args) {
        // System.out.println(subarrayBitwiseORs2(new int[]{89,15,88,07,55,796,176,178}));
        //System.out.println(subarrayBitwiseORs2(new int[]{6,12,7}));
        //System.out.println(subarrayBitwiseORs2(new int[]{1,1,2}));
        System.out.println(subarrayBitwiseORs3(new int[]{1, 2, 4}));
//     System.out.println(subarrayBitwiseORs(new int[]{0}));
    }

    // 数组多多时候会超时
    public static int subarrayBitwiseORs(int[] A) {
        Set<Integer> result = new HashSet<>();
        int step = 1;
        while (step <= A.length) {
            for (int i = 0; i < A.length; i++) {
                int temp = 0;
                int times = 0;
                for (int j = i; j < A.length && times < step; j++) {
                    times++;
                    temp = temp | A[j];
                }
                result.add(temp);
            }
            step++;

        }
        return result.size();
    }

    //注意是连续的子数组
    public static int subarrayBitwiseORs2(int[] A) {
        Set<Integer> set = new HashSet<>();//最后的结果
        Set<Integer> pre = new HashSet<>();//上一组的或操作结果集合
        Set<Integer> cur = new HashSet<>();//当前组的或操作结果集合
        //dp[i][j]代表从A[i] | A[i+1] | ... | A[j]
        //dp[][j - 1]代表最后一个元素在原数组中的索引为j - 1的子数组
        //dp[i][j]是dp[i][j - 1] | A[j]，但是dp[i - k][j]和dp[i][j]可能有重复，只需要计算其中一个即可
        //这里我们可以使用set记录每一组dp[][j]的结果，每次只要A[i]*set(k)再加上一个A[i]即可
        for (int i = 0; i < A.length; i++) {
            cur.clear();
            //set.add(A[i]);
            cur.add(A[i]);
            for (int num : pre) {
                int tmp = (A[i] | num);
                //set.add(tmp);
                cur.add(tmp);
            }
            set.addAll(cur);
            pre.clear();
            pre.addAll(cur);
        }
        return set.size();
    }

    //注意是连续的子数组
    public static int subarrayBitwiseORs3(int[] A) {
        LinkedList<Integer> result = new LinkedList<>();//最后的结果
        int startIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (!result.contains(A[i])) {
                result.add(A[i]);
            }
            int len = result.size();
            for (int j = startIndex; j < len; j++) {
                int tmp = (A[i] | result.get(j));
                if (!result.contains(tmp)) {
                    result.add(tmp);
                }
            }
            startIndex = len;
        }

        return result.size();
    }
}
