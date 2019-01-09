package com.qiwx.string;
//字符串的最短距离
public class ShortestToChar {
    public static void main(String[] args) {
     System.out.println(shortestToChar("loveleetcode",'e'));
    }
    private static int[] shortestToChar(String S,char C){
        int[] a=new int[S.length()];
        int left,right;//一个向左查找一个向右查找
        int len=S.length();
        for(int i=0;i<len;i++){
            if(S.charAt(i)==C){
                a[i]=0;
            }else{
                int leftCout=0;
                int rightCount=0;
                left=i-1;
                right=i+1;
                while (true){
                    if(left>=0){
                        if(S.charAt(left)!=C){
                            leftCout++;
                        }else{
                            break;
                        }
                    }
                    if(right<len){
                        if(S.charAt(right)!=C){
                            rightCount++;
                        }else{
                            break;
                        }

                    }
                }

                if(leftCout==0&&rightCount==0){
                    a[i]=0;
                }else if(leftCout!=0&&rightCount!=0){
                    a[i]=leftCout<=rightCount?leftCout:rightCount;
                }else{
                    a[i]=leftCout<=rightCount?leftCout:rightCount;
                }

            }
        }
        return a;
    }
}
