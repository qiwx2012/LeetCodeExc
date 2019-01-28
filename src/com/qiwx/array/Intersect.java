package com.qiwx.array;

import java.lang.reflect.Array;
import java.util.*;

//两个数组的交集
public class Intersect {
    public static void main(String[] args) {
        //intersect1(new int[]{4,9,5},new int[]{9,4,9,8,4});
        intersect1(new int[]{1,2,2,1},new int[]{2});
    }
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }

        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ret[i] = list.get(i);
        }
        return ret;
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list=new LinkedList<>();
        for(int s:nums1){
            list.add(s);
        }
        List<Integer> list2=new LinkedList<>();
        for(int i:nums2){
            if(list.contains(i)){
                list2.add(i);
                list.remove(Integer.valueOf(i));
            }

        }
        int len=list2.size();
        int[] result=new int[len];
        int index=0;
        for(Integer i:list2){
            result[index]=i;
            index++;
        }
        return result;
    }
}
