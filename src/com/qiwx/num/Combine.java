package com.qiwx.num;

import java.util.LinkedList;
import java.util.List;

//组合
public class Combine {

    public static void main(String[] args) {
        combine(4,2);
    }
    static List<List<Integer>> result=new LinkedList<>();
    public static List<List<Integer>> combine(int n, int k) {
         List<Integer> list=new LinkedList<>();
         addNums(list,n,k);
         return result;
    }
    private static void addNums( List<Integer> list,int n,int k){
         if(list.size()==k){
             result.add(list);
         }else {
             list.add(n--);
         }
         if(n>k){
             addNums(list,n--,k);
         }


    }
}
