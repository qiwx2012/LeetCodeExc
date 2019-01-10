package com.qiwx.num;

import java.util.ArrayList;
import java.util.List;

//杨辉三角
public class GetRow {
    public static void main(String[] args) {
        getRow1(4);
    }
    public static List<Integer> getRow1(int rowIndex) {
        List<Integer> result=new ArrayList<>();
        result.add(1);
        result.add(1);
        if(rowIndex==0){
            return result.subList(0,1);
        }else if(rowIndex==1){
            return result;
        }else {
           //由于杨辉三角的特性，第rowIndex行的数组为rowIndex+1;
            while (result.size()<=rowIndex+1){
                int len=result.size();
               for(int i=0;i<len-1;i++){
                   int addNum=result.get(i)+result.get(i+1);
                   if(result.get(i+1)!=1){
                       result.set(i+1,addNum);
                   }

               }
            }



        }
        return result;

    }
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result=new ArrayList<>();
        result.add(1);
        result.add(1);
        if(rowIndex==0){
            return result.subList(0,1);
        }else if(rowIndex==1){
            return result;
        }else {
            int start=2;
            while (start<=rowIndex){
                List<Integer> temp=new ArrayList();
                int size=result.size();
                for(int i=size-1;i>0;i--){
                    int addNum=result.get(i)+result.get(i-1);
                    temp.add(addNum);
                }
                temp.add(0,1);
                temp.add(1);
                start++;
                result.clear();
                result.addAll(temp);

            }


        }
        return result;

    }
}
