package com.qiwx.num;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// 二进制手表
public class ReadBinaryWatch {
    public static void main(String[] args) {
        readBinaryWatch(1);
    }
    public static List<String> readBinaryWatch(int num) {
        List<String>result=new LinkedList<>();
        if(num==0){
            result.add("0:00");
            return result;
        }
        Map<Integer,Integer> lightNums=new HashMap<>();
        //查出1-59点需要亮几个灯
        for(int i=1;i<=59;i++){
            int count=0;
            int time=i;
            while (time!=0){
                count++;
                time=time&(time-1);
            }
            lightNums.put(i,count);
        }

        for(int i=1;i<=59;i++){
            int minute=lightNums.get(i);
            if(minute==num){
                String content=null;
                if(i<=11){
                     content=i+":"+"00";
                    if(!result.contains(content)){
                        result.add(content);
                    }
                }
                content="0:"+addZero(i);
                if(!result.contains(content)){
                    result.add(content);
                }
                continue;
            }else if(minute<num){
                for(int j=1;j<=11;j++){
                    int hour=lightNums.get(j);
                    if(minute+hour==num){
                       String  content=j+":"+addZero(i);
                        if(!result.contains(content)){
                            result.add(content);
                        }
                    }
                }
            }

        }
        return result;
    }
    public static String addZero(int num){
        if(num>9){
            return String.valueOf(num);
        }else {
            return "0"+num;
        }
    }
}
