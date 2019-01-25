package com.qiwx.array;
//最大连续1的个数
public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
          System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int len=nums.length;
        int start=0;
        int max=0;
        //遇到1就加 遇到0就清零
        for(int i=0;i<len;i++){
            if(nums[i]==1){
                start++;
            }else{
                if(max<start){
                    max=start;
                }
                start=0;
            }
        }
        return max>start?max:start;
    }
}
