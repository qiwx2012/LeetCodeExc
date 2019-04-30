package com.qiwx.bit;
// UTF-8 编码验证
public class ValidUtf8 {
    public static void main(String[] args) {
      System.out.println(validUtf8(new int[]{197,130,1}));
      System.out.println(validUtf8(new int[]{235,140,4}));
      System.out.println(validUtf8(new int[]{230,136,145}));
      System.out.println(validUtf8(new int[]{248,130,130,130}));
    }
    public static boolean validUtf8(int[] data) {
        //UTF-8规则
        //对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
//        一个字节：0xxxxxxx;
//        两个字节：110xxxxx 10xxxxxx;
//        三个字节：11100000 10xxxxxx 10xxxxxx;
//        四个字节：11110000 10xxxxxx 10xxxxxx 10xxxxxx;
        //根据UTF-8的规则
        //11100110 10001000 10010001 230 236 145
        //11111000 10000010 248  130
        int bitNum=0;
        for(int i=0;i<data.length;i++){
            if(bitNum==0){
                if(((1<<7)&data[i])==0){
                    bitNum=0;
                    continue;
                }else {
                    if(data[i]>>3==30){
                        bitNum=3;//4个字节 剩余三个字节待验证
                    }else if(data[i]>>4==14){
                        bitNum=2;
                    }else if(data[i]>>5==6){
                        bitNum=1;
                    }else {
                        bitNum=1;
                        break;
                    }
                }

            }else {
                if((data[i]&(2<<6))!=(2<<6)){
                    bitNum=1;
                    break;
                }
                bitNum--;
            }


        }
        return bitNum==0;

    }
}
