package com.qiwx.num;

//七进制数
public class ConvertToBase7 {
    public static void main(String[] args) {
        convertToBase7(100);
    }

    public static String convertToBase7(int num) {

        StringBuffer sb = new StringBuffer();
        int offet = 0;
        if (num < 0) {
            sb.append("-");
            num = Math.abs(num);
            offet = 1;
        }

        while (num / 7 > 0) {
            int temp = num % 7;
            sb.insert(offet, temp);
            num = num / 7;
        }
        sb.insert(offet, num);
        return sb.toString();

    }
}
