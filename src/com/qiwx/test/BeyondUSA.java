package com.qiwx.test;
//计算什么时候中国GDP会超过美国
public class BeyondUSA {
    public static void main(String[] args) {
        //美国2018年GDP总额 20.51万亿
        //中国2018年GDP总额 13.41万亿
        //假设中国每年比美国多两个百分点 多少年可以超过美国
        double usa=20.51;
        double china=13.41;
        int year=2018;
        while (china<usa){
            System.out.println(String.format("今年是：%d,美国GDP是%f亿美元,中国GDP是%f亿美元",year++,usa,china));
            usa=usa*(1+0.02);
            china=china*(1+0.064);
        }
        System.out.println(String.format("今年是：%d,美国GDP是%f亿美元,中国GDP是%f亿美元",year++,usa,china));
    }
}
