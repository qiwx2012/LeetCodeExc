package com.qiwx.num;

//比特位计算
public class CountBits {
    public static void main(String[] args) {
        // System.out.println(countBits(5));
         System.out.println(countBits1(5));
    }

    public static int[] countBits(int num) {
        int[] nums = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int j=0;
            int a=i;
            while (a>0){
                j++;
                a=a&(a-1);
            }
            nums[i]=j;

        }
        return nums;
    }
    //
    public static int[] countBits1(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        //先将所有的num转化为偶数处理，因为没有都是处理两个数
        int n = num%2 !=0 ? num-1:num;
        for(int i = 1; i <= n;i++){
            //a[n] = a[n/2] n为偶数
            res[i] = res[i-1]+1;
            i++;
            //a[n] = a[n-1] +1 n为基数
            res[i] = res[i/2];
        }
        //最后有个奇数没有处理,奇数1都是前一个1的总数+1
        if(num % 2 != 0){
            res[num] = res[n] + 1;
        }
        return res;
    }
}
