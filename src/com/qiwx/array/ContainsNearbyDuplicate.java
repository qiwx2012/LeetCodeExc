package com.qiwx.array;

import java.util.HashMap;
import java.util.Map;

//存在重复元素 II
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
//        containsNearbyDuplicate(new int[]{99,99},2);
       // containsNearbyDuplicate(new int[]{1,2,3,1,99},3);
        containsNearbyDuplicate(new int[]{1,0,1,1},1);
    }
    public static  boolean containsNearbyDuplicate(int[] nums, int k) {
        int len=nums.length;
        Map<Integer,Integer> maps= new HashMap<>();
        boolean isFind=false;
        for(int i=0;i<len;i++){
            if(!maps.containsKey(nums[i])){
                maps.put(nums[i],i);
            }else {
                isFind =i-maps.get(nums[i])<=k;
                if(isFind){
                    return true;
                }else {
                    maps.put(nums[i],i);
                }
            }

        }
        return false;
    }
}
