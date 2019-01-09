package com.qiwx.string;

import java.util.Vector;

//字符串的最短距离
public class ShortestToChar {
    public static void main(String[] args)
    {
     System.out.println(shortestToChar("loveleetcode",'e'));
     System.out.println(shortestToChar("e",'e'));

    }
    private static int[] shortestToChar(String S,char C){
        int[] a=new int[S.length()];
        int left,right;//一个向左查找一个向右查找
        int leftCout=0;
        int rightCount=0;//单独统计左右偏移量
        int len=S.length();
        for(int i=0;i<len;i++){
            if(S.charAt(i)==C){
                a[i]=0;
            }else{
                rightCount=0;
                leftCout=0;
                left=i-1;
                right=i+1;
                while (true){
                    if(left>=0){
                        if(S.charAt(left)!=C){
                            leftCout++;
                            left--;
                        }else{
                            a[i]=leftCout+1;
                            break;
                        }
                    }
                    if(right<len){
                        if(S.charAt(right)!=C){
                            rightCount++;
                            right++;
                        }else{
                            a[i]=rightCount+1;
                            break;
                        }

                    }
                }

            }
        }
        return a;
    }
}
