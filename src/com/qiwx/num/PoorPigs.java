package com.qiwx.num;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

//可怜的小猪
public class PoorPigs {
    public static void main(String[] args) {
        System.out.println(poorPigs(1000,15,60));
    }

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
             if(buckets==1)
                 return 0;//题意是至少有一个是有毒的
             int base=minutesToTest/minutesToDie+1;
             int pigs=0;
             //在规定时间内可以检测多少只水桶
             int count=1;
             while (count<buckets){
                 count*=base;
                 pigs++;
             }
            return pigs;
    }
}
