package com.qiwx.string;
//8. 字符串转换整数 (atoi)
public class MyAtoi {
    public static void main(String[] args) {
     //System.out.println(myAtoi("42"));

     //System.out.println(myAtoi1("3.14"));
     //System.out.println(myAtoi1("-04f"));
    // System.out.println(myAtoi(" 0000000000012345678"));
     System.out.println(myAtoi1(" 0000000000012345678"));
     System.out.println(myAtoi1("+"));
     System.out.println(myAtoi1("-0012a42"));
//     System.out.println(myAtoi1("   -42"));
     System.out.println(myAtoi1("3.14"));
     System.out.println(myAtoi1("4193 with words"));
     System.out.println(myAtoi1("words and 987"));
     System.out.println(myAtoi1("words and 987"));
     System.out.println(myAtoi1("-"));
     System.out.println(myAtoi1("+"));
    }
    public static int myAtoi(String str){
        if(str==null)
            return 0;
        char[] chars=str.toCharArray();
        boolean isStart=false;
        int flag=1;
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<chars.length;i++){
            if(chars[i]==' '){
                if(isStart){
                    break;
                }else {
                    continue;
                }

            }else if(chars[i]>='0'&&chars[i]<='9'){
                isStart=true;
            }else if(chars[i]=='-'||chars[i]=='+'){
                if(isStart){
                    break;
                }else {
                    isStart=true;
                    if(chars[i]=='-')
                    flag=-1;
                    continue;
                }
            }else {
                if(isStart){
                    break;
                }else {
                    return 0;
                }

            }
            if(isStart){
               sb.append(chars[i]); }

        }
        if(flag==-1){
            if(sb.length()>0)
            sb.insert(0,'-');
        }
        int result=0;
        if(sb.length()==0)
            return 0;
        try {
            result=Integer.parseInt(sb.toString());
        }catch (NumberFormatException e){
           return flag==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;

        }
        return result;
    }
    public static int myAtoi1(String str){
        if(str==null)
            return 0;
        int len=str.length();
        if(len==0)
            return 0;
        //char[] chars=str.toCharArray();
        boolean isStart=false;
        int startIndex=0;
        int endIndex=0;
        int result=0;
        int flag=1;//负数为-1 正数为1
        for(int i=0;i<len;i++) {
            char c=str.charAt(i);
            if(c==' '){
                if(!isStart){
                    startIndex=i+1;
                    endIndex=i+1;
                    continue;

                }else {
                    break;
                }

            } else if(c=='-'||c=='+'){
                if(!isStart){
                    endIndex=i+1;
                    startIndex=i+1;
                    isStart=true;
                    if(c=='-'){
                        flag=-1;
                    }
                }else {
                    break;
                }

            }else if(c>='0'&&c<='9'){
                if(isStart){
                    endIndex=i+1;
                }else {
                    isStart=true;
                    endIndex=i+1;
                }
            }else {
                break;
            }
        }
        if(startIndex==endIndex)
            return 0;
        String temp="";

        if(flag==-1){
            startIndex--;
        }
        temp = str.substring(startIndex, endIndex);

        try {
            result=Integer.parseInt(temp);
        }catch (NumberFormatException e){
            return flag==-1?Integer.MIN_VALUE:Integer.MAX_VALUE;

        }
        return result;
    }
}
