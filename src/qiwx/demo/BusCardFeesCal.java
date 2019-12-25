package qiwx.demo;

import java.math.BigDecimal;
import java.util.Random;

//公交卡费用计算器
public class BusCardFeesCal {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(monthCal(10));
        }
    }

    public static double monthCal(double remain) {
        double curMonthConsume = 0;//当月消费额度
        BigDecimal b = new BigDecimal(curMonthConsume);
        for (int i = 0; i < 31; i++) {
            if (curMonthConsume <= 100) {
                curMonthConsume += getPrice();
            } else if (curMonthConsume <= 150) {
                curMonthConsume += getPrice() * 0.8;
            } else if (curMonthConsume <= 400) {
                curMonthConsume += getPrice() * 0.5;
            } else {
                curMonthConsume += getPrice();
            }
            b = new BigDecimal(curMonthConsume);
            System.out.println(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());

        }

        curMonthConsume = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return curMonthConsume;


    }

    //随机一个消费额度 3-8
    private static int getPrice() {
        Random random = new Random();
        int num = random.nextInt(8) % (8 - 3 + 1) + 3;
        return num;


    }
}
