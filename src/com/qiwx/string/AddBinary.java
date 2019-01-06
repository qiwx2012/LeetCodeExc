package com.qiwx.string;
//二进制求和
public class AddBinary {
    public static void main(String[] args) {
         System.out.println(addBinary("1010","1011"));
         System.out.println(addBinary("1111","1111"));
        // System.out.println(addBinary("0","0"));
        // System.out.println(addBinary("100","110010"));
    }
    private static String addBinary(String a,String b){
        char[] mins=a.length()<b.length()?a.toCharArray():b.toCharArray();
        char[] maxs=b.length()<=a.length()?a.toCharArray():b.toCharArray();
        int carray=0;
        int minLen=mins.length;
        int maxLen=maxs.length;
        StringBuffer sb=new StringBuffer();
        for(int i=minLen-1,j=maxLen-1;j>=0;i--,j--){
            char curr='0';
            if(i>=0)
            {
                curr=mins[i];
            }
            if(curr=='1'&&maxs[j]=='1'){
                if(carray==1){
                    sb.insert(0,'1'); //carry 不需要修改，此情况需要继续进位
                }else{
                    sb.insert(0,'0');
                    carray=1;
                }
            }else if(curr=='0'&&maxs[j]=='0'){
                if(carray==1){
                    sb.insert(0,'1');
                    carray=0;
                }else {
                    sb.insert(0,'0');
                }
            }else {//因为只有0 和1 所以两个不相等意味着相加肯定是1
                if(carray==1){
                    sb.insert(0,'0');//carry 不需要修改，此情况需要继续进位
                }else {
                    sb.insert(0,'1');
                }
            }
        }
        if(carray==1){
            return sb.insert(0,'1').toString();
        }else {
            return sb.toString();
        }

    }
}
