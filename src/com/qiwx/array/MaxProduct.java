package com.qiwx.array;


//最大单词长度
public class MaxProduct {
    public static void main(String[] args) {
     System.out.println(maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
    }

    public static int maxProduct(String[] words) {
        int len=words.length;
        if (len <= 1)
            return 0;
        //一个int 有32位二进制组成，可以用前26位表示是否含有字母，包含为1，不包含为0
        int[] bitvalue=new int[len];
        for(int i=0;i<len;i++){
            for(int j=0;j<words[i].length();j++){
                //根据字符大小a-z分别对应 左移0-25位
                int moveBit=words[i].charAt(j)-'a';
                bitvalue[i]|=1<<moveBit;
            }
        }
        int tmp,result=0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                //如果两个字符串没有共有字符，与操作之后值应该是0
                //如果不为零说明有公共字符
                if((bitvalue[i]&bitvalue[j])==0){
                    tmp = words[i].length()*words[j].length();
                    result = tmp>result?tmp:result;

                }
            }
        }
        return result;




    }

}
