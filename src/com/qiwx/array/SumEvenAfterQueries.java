package com.qiwx.array;
//查询后的偶数和
public class SumEvenAfterQueries {
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,4};
        int[][]b=new int[][]{{1,0},{-3,1},{-4,0},{2,3}};
        sumEvenAfterQueries(a,b);
    }
    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        int[]result=new int[A.length];
        int len=queries.length;
        int count=0;
        //计算原始A的偶数和
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                count+=A[i];
            }
        }
        for(int i=0;i<len;i++){
            int index=queries[i][1];
            if(A[index]%2==0&&queries[i][0]%2==0){
                count+=queries[i][0];
                A[index]+=queries[i][0];
            }else if(A[index]%2==0&&queries[i][0]%2!=0){
                //一个奇数一个偶数，结果为奇数
                count=count-A[index];
                A[index]+=queries[i][0];
            }else if(A[index]%2!=0&&queries[i][0]%2!=0){
                A[index]+=queries[i][0];
                count+=A[index];
            }else {
                A[index]+=queries[i][0];
            }
            result[i]=count;

        }
        return result;
    }
}
