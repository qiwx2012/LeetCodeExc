package com.qiwx.array;

//最小移动次数使数组元素相等
public class MinMoves {
    public static void main(String[] args) {

    }

    //思路就是，每次移动整个数组的和增加n-1,设移动次数为times，初始数列最小值min,
    // 初试数列和sum。则满足(min+n-1)*numsSize==sum+times*(n-1).
    // 化简这个式子可得 return sum-numsSize*min;
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            sum += num;
        }
        return sum - min * nums.length;
    }
    //逆向思考，每次移动让剩余的n-1个数加1，相当于每次移动让选定的那个数减1，
    //所以最少移动次数其实就是所有元素减去最小元素的和
}
