package com.qiwx.string;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//基本计算器2
public class Calculate {
    public static void main(String[] args) {
//     System.out.println(calculate("1-1"));
//     System.out.println(calculate("0-26776"));
//     System.out.println(calculate("100000000/1/2/3/4/5/6/7/8/9/10"));
//     System.out.println(calculate("3*2*4"));
//     System.out.println(calculate("3/2"));
     //System.out.println(calculate(" 3+5 / 2 "));
     //测试
        LinkedList<Integer> nums=new LinkedList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.addFirst(5);
        for (Integer i:nums){
            System.out.println(i);
        }

    }
    public static int calculate(String s) {
        char[] chars=s.toCharArray();
        //栈结构先进先出
        LinkedList<Integer> nums=new LinkedList<>();
        LinkedList<Character> ops=new LinkedList<>();
        boolean isNumFinish=false;//判断一个数是否完成
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<chars.length;i++){
            if(chars[i]>='0'&&chars[i]<='9'){
                if(isNumFinish){
                    isNumFinish=false;
                    sb.append(chars[i]);
                }else {
                    sb.append(chars[i]);
                }
            }else if(chars[i]==' '){
                //不做任何操作
            }else {
                isNumFinish=true;
                ops.add(chars[i]);
                nums.add(Integer.parseInt(sb.toString()));
                sb=sb.delete(0,sb.length());

            }
        }
        if(sb.length()>0){
            nums.add(Integer.parseInt(sb.toString()));
        }
        int result=0;
        while (ops.size()>0){
            char c=ops.pop();
            switch (c){
                case '+':
                    result+=nums.pop();//加法直接先加第一个操作数
                    break;
                case '-':
                    result+=nums.pop();//与加法一样，先将第一个操作数相加
                    int aa=-nums.pop();//然后将第二个操作数变换成负数
                    nums.addFirst(aa);
                    break;
                case '*':
                    int a=nums.pop()*nums.pop();
                    nums.addFirst(a);
                    break;
                case '/':
                    int b=nums.pop()/nums.pop();
                    nums.addFirst(b);
                    break;
            }
        }

        for (Integer i:nums){
            result+=i;
        }
        return result;
    }
}
