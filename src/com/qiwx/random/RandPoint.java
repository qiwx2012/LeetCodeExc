package com.qiwx.random;

import java.util.Random;

//478. 在圆内随机生成点
public class RandPoint {
    public static void main(String[] args) {

    }
    public static double[] randPoint() {
        double x_center=0,y_center=0;
        double radius=0;
        double r=radius*radius;
        double dx=radius-radius*2*Math.random();//随机一个[0,2*radius] 的值
        double dy=radius-radius*2*Math.random();
        if(dx*dx+dy*dy>r){
            return randPoint();
        }
        return new double[]{dx+x_center,dy+y_center};

    }
}
