package com.qiwx.num;

import java.util.LinkedList;
import java.util.List;

//强整数
public class PowerfulIntegers {
    public static void main(String[] args) {
        powerfulIntegers(2,3,10);
    }
    public  static List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> result=new LinkedList<>();

        for(int i=0;i<bound;i++){
            int t1=(int)Math.pow(x,i);
            if(t1>bound)
                break;
            for(int j=0;j<bound;j++){
              int temp=t1+(int)(Math.pow(y,j));
              if(temp<=bound){
                  if(!result.contains(temp))
                     result.add(temp);
              }else {
                  break;
              }

            }
        }
        return result;


    }
}
