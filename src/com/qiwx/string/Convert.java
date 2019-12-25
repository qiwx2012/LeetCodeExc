package com.qiwx.string;

//Z形转换
public class Convert {
    public static void main(String[] args) {
        //System.out.println(convert("LEETCODEISHIRING",3));
        // System.out.println(convert("LEETCODEISHIRING",4));
        System.out.println(convert("", 4));
    }

    private static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        if (s == null || s.length() == 0) {
            return "";
        }
        //根据形状特性，第一行步幅为step=n+(n-2)
        int step = numRows + (numRows - 2);
        StringBuffer[] sbs = new StringBuffer[numRows];
        for (int i = 0; i < s.length(); i++) {
            int index = i % step;
            if (index < numRows) {
                if (sbs[index] == null) {
                    sbs[index] = new StringBuffer();
                }
                sbs[index].append(s.charAt(i));
            } else {
                int temp = step - index;
                sbs[temp].append(s.charAt(i));
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sbs.length; i++) {
            if (sbs[i] != null) {
                sb.append(sbs[i].toString());
            }
        }
        return sb.toString();
    }
}
