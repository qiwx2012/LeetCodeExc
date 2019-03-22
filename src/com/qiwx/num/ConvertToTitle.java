package com.qiwx.num;
// Excel表列名称
public class ConvertToTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
    }
    public static String convertToTitle(int n) {

        StringBuffer sb=new StringBuffer();
        while (n/26>0){
           int offset=n%26;
           n--;
           char cc=(char)('A'+offset);
           sb.insert(0,cc);
           n=n/26;
        }
        char cc=(char)('A'+n);
        sb.insert(0,cc);

        return sb.toString();

    }
    public static String convertToTitle1(int n) {

        if (n <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            sb.append((char) (n % 26 + 'A'));
            n =n / 26;
        }
        return sb.reverse().toString();

    }

}
