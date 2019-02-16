package com.qiwx.array;

import java.util.HashMap;
import java.util.Map;

//压缩字符串
public class Compress {
    public static void main(String[] args) {
         compress(new char[]{'a','a','b','b','c','c','c'});
         //compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'});
         compress(new char[]{'a','b','c'});
        // compress(new char[]{'a','a'});
         compress(new char[]{'a','a','a','a','a','b'});
    }
    public static int compress(char[] chars) {
        int len=chars.length;
        if(len==1)
            return len;
        int index=0;
        int start=0;
        for(int i=0;i<len;i++){
            if(i==0){
                start++;
            }else {
                if(i==len-1){
                    if(chars[i]==chars[i-1]){
                        start++;
                    }
                    if(start>1){
                        chars[index]=chars[i-1];
                        index++;
                        char[] cc=String.valueOf(start).toCharArray();
                        for (int j=0;j<cc.length;j++){
                            chars[index]=cc[j];
                            index++;
                        }
                    }else {
                        chars[index]=chars[i-1];
                        index++;
                    }
                }else {
                    if(chars[i]!=chars[i-1]){
                        if(start>1){
                            chars[index]=chars[i-1];
                            index++;
                            char[] cc=String.valueOf(start).toCharArray();
                            for (int j=0;j<cc.length;j++){
                                chars[index]=cc[j];
                                index++;
                            }
                        }else {
                            chars[index]=chars[i-1];
                            index++;
                        }
                        start=1;
                    }else  {
                        start++;
                    }
                }

            }
        }
        if(!(chars[index-1]>='1'&&chars[index-1]<='9')){
            if(chars[index-1]!=chars[index-2]){
                index++;
            }
        }


        return index;
    }
    private static int compress1(char[] chars){
        if(chars.length==1){
            return 1;
        }
        int temp = 0;
        for (int i = 0; i <chars.length ; i++) {
            char c  =chars[i];
            int count = 1;
            for (int j = i+1; j < chars.length; j++) {
                if(c==chars[j]){
                    count ++;
                }else {
                    break;
                }
            }
            if(temp==0){
                temp = i;
            }
            chars[temp] = c;
            temp+=1;
            if(count>1){
                String str = String.valueOf(count);
                for (int j = 0; j <str.toCharArray().length ; j++) {
                    chars[temp]  =  str.toCharArray()[j];
                    temp+=1;

                }
            }
            if(i+count>=chars.length){
                char [] arrNew = new  char[temp];
                System.arraycopy(chars, 0, arrNew, 0, arrNew.length);
                chars = arrNew;
                return  temp;
            }
            i = i+count-1;

        }

        return chars.length;
    }
}
