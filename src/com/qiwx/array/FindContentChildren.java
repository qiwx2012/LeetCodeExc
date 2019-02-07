package com.qiwx.array;

import java.util.Arrays;

//分发饼干
public class FindContentChildren {
    public static void main(String[] args) {
        //System.out.println(findContentChildren(new int[]{1,2,3},new int[]{1,1}));
        System.out.println(findContentChildren(new int[]{1,2},new int[]{1,2,3}));
    }
    public static int findContentChildren(int[] g, int[] s) {
          Arrays.sort(s);
          Arrays.sort(g);
          int len=s.length;
          int len1=g.length;
          int index=0;
          int count=0;
          for(int i=0;i<len;i++){
              if(index>len1-1)
                  break;
              if(s[i]>=g[index]){
                 count++;
                 index++;
              }
          }
          return count;
    }
}
