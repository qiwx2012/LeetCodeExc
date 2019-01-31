package com.qiwx.string;

import java.util.LinkedList;
import java.util.List;

//不含 AAA 或 BBB 的字符串
public class StrWithout3a3b {
    public static void main(String[] args) {
      System.out.println(strWithout3a3b(2,5));
      System.out.println(strWithout3a3b(4,1));
      System.out.println(strWithout3a3b(2,3));
      System.out.println(strWithout3a3b(1,2));
      System.out.println(strWithout3a3b(2,2));
    }
    public static String strWithout3a3b(int A, int B) {

        List<Character> list=new LinkedList<>();
        char a='a';
        char b='b';
        if(A<B){
            a='b';
            b='a';
            A=A^B;
            B=A^B;
            A=A^B;

        }

         for(int i=0;i<A;i++){
             list.add(a);
         }
         int current=2;
         int leave=B;
        for(int i=0;i<B;){
            int len=list.size();
            boolean isAdd=false;
            for(int j=0;j<len-current;j=j+current){
                if(current==2){
                    if(list.get(i)==list.get(i+1)
                            &&list.get(i+1)==list.get(i+2)){
                        if(leave<=0){
                            break;
                        }
                        char add=list.get(i)==a?b:a;
                        list.add(j+2,add);
                        leave--;
                        i++;
                        isAdd=true;
                    }
                }else {
                    if(list.get(i)==list.get(i+1)){
                        if(leave<=0){
                            break;
                        }
                        char add=list.get(i)==a?b:a;
                        list.add(j+1,add);
                        leave--;
                        i++;
                        isAdd=true;
                    }
                }

            }
            if(!isAdd){
                if(leave>0){
                    list.add(len,b);
                }

                i++;
            }
            current--;


        }
        StringBuffer sb=new StringBuffer();
        for(Character c:list){
            sb.append(c);
        }
        return sb.toString();


    }
}
