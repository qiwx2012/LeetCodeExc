package com.qiwx.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//亲密字符串
public class BuddyStrings {
    public static void main(String[] args) {
            System.out.println(buddyStrings("abcd","badc"));
            System.out.println(buddyStrings("ab","ab"));
            System.out.println(buddyStrings("aaaaaaabc","aaaaaaacb"));
    }
    private static boolean buddyStrings(String A,String B){

        if(A.length()!=B.length())
            return false;
        char[] charsA=A.toCharArray();
        char[] charsB=B.toCharArray();
        int len=charsA.length;
        char[][] chars=new char[][]{{1,1},{2,2}};
        int index=0;
        for(int i=0;i<len;i++){
           if(charsA[i]!=charsB[i]){
               if(index>=2)
                   return false;
               chars[index][0]=charsA[i];
               chars[index][1]=charsB[i];
               index++;
           }
        }
        if(index==0){
           //如果size==0,说明A==B,此时只要A中有重复元素就是亲密字符串
           Set<Character> sets=new HashSet<>();
           for(int i=0;i<len;i++){
               if(!sets.contains(charsA[i])){
                  sets.add(charsA[i]);
               }else {
                   return true;
               }
           }
           return false;


        }else if(index==2){
            if(chars[0][0]==chars[1][1]&&chars[0][1]==chars[1][0]){
                return true;
            }else {
                return false;
            }
        }else {
           return false;
        }


    }
}
