package com.qiwx.test;

/**
 * @description
 * @Author qiwx
 * @Date 2020-09-27 17:24
 * 给你一个整数数组 digits，你可以通过按任意顺序连接其中某些数字来形成 3 的倍数，请你返回所能得到的最大的 3 的倍数。
 **/
public class LargestMultipleOfThree {


    public static void main(String[] args) {
//        new LargestMultipleOfThree().largestMultipleOfThree(new int[]{8,1,9});
        new LargestMultipleOfThree().largestMultipleOfThree(new int[]{0,0,0,0});
    }
    public String largestMultipleOfThree(int[] digits) {
        int[] numbers = new int[10];//将0-9每个数出现的次数放入此数组
        int sum = 0;//总和
        for (int x : digits) {
            numbers[x]++;
            sum += x;
        }
        int q = sum % 3;
        //如果del()返回是小于0 数组中肯定存在两个余数为 1或者2的数存在
        if (q > 0 && del(numbers, q) < 0) {
            //删除两次 当余数是1 时 3-q 等于2 删除两次mod余2的数 ，余数为2一样道理
            del(numbers, 3 - q);
            del(numbers, 3 - q);
        }
        String res = "";
        for (int i = 9; i >= 0; i--) {
            while (numbers[i]-- > 0) {
                res += i;
            }
        }
        if (res.length() > 0 && res.charAt(0) == '0')
            return "0";
        return res;


    }

    //删除 number%3=1 的数有 1 4 7 ，number%3=2的数有 2 5 8

    //如果 [公式] ，那么所有数都选中就行了。
    //如果 [公式] ，那么必须删掉一个模 [公式] 余 [公式] 的数（按照从小到大顺序删除 1、4、7）。如果这三个数都没有，那就要删除两个模 [公式] 余 [公式] 的数（按照从小到大顺序删除 2、5、8，删除两次）。
    //如果 [公式] ，那么必须删掉一个模 [公式] 余 [公式] 的数（按照从小到大顺序删除 2、5、8）。如果这三个数都没有，那就要删除两个模 [公式] 余 [公式] 的数（按照从小到大顺序删除 1、4、7，删除两次）。
    public int del(int[] digits, int q) {
        for (int i = 0; i < 10; i++) {
            if (i % 3 == q && digits[i] > 0) {
                return --digits[i];
            }
        }
        return -1;

    }

}
