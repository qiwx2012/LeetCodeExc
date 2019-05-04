package com.qiwx.bit;
//汉明距离总和
public class TotalHammingDistance {
    public static void main(String[] args) {
      System.out.println(totalHammingDistance(new int[]{4,14,2}));
    }
    public static int totalHammingDistance(int[] nums) {
        int total = 0;
        for(int i = 0; i < 32; i++) {
            int distance = 0;
            for(int j = 0; j < nums.length; j++) {
                if((nums[j] & (1 << i - 1)) != 0)//计算每个位上面有多少个1
                    distance++;
            }
            //分次计算，每次计算一个位上1的个数 剩下0的个数，两个想乘就是该位上的
            //汉明距离，然后将每位上汉明距离相加即可
            total += distance*(nums.length - distance);//总数减去1的个数剩下的就是0的个数
        }
        return total;
//        if(nums.length<=1)
//            return 0;
//        int count=0;
//       for(int i=0;i<nums.length;i++){
//           for(int j=i+1;j<nums.length;j++){
//               {
//                   count+=calDistance(nums[i],nums[j]);
//
//               }
//           }
//       }
//       return count;

    }
    private static  int calDistance(int a,int b){
        int distance=0;
        int x=a^b;//异或操作后，对应位值不一样会变成1，然后再统计x中有多少个1
        while (x>0){
           if(x%2!=0){
               distance++;
           }
           x=x>>1;
        }
        return distance;
    }
    //超时
    private static  int calDistance1(int a,int b){
        int distance=0;
        while (a>0||b>0){
            int x=a%2;
            int y=b%2;
            if((x==0&&y==1)||(x==1&&y==0)){
                distance++;
            }
            a=a>>1;
            b=b>>1;
        }
        return distance;
    }
}
