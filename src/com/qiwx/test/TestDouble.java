package com.qiwx.test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class TestDouble {
    public static void main(String[] args) {
        double b=12.33644;
        DecimalFormat decimalFormat=new DecimalFormat("#.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        System.out.println(decimalFormat.format(b));
        System.out.println(String.format("%.2f", b));
        System.out.println(Math.floor(b));
        System.out.println(Math.ceil(b));
    }
}
