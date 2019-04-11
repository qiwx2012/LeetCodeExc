package com.qiwx.num;
//灯泡开关
public class BulbSwitch {
    public static void main(String[] args) {
        System.out.println(bulbSwitch1(
                99999));
        System.out.println(bulbSwitch1(8));
    }
    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
    public static int bulbSwitch1(int n) {
        if(n==0)
            return 0;
        if(n<=3)
            return 1;
        //当n大于3的时候 前三个灯不会再产生任何变化，
        //永远是[开，关，关]
        int open=1;
        for(int i=1;i<=n;i++){
            int index=0;
               for(int j=2;j<i;j++){
                   if(i%j==0){
                       if(index==0){
                           index=1;
                       }else {
                           index=0;
                       }
                   }
               }
            if(index==1){
                open++;
            }

//            for(int j=1;j<=n;j++){
//                if(j%i==0){
//                    if(s[j-1]==0){
//                        s[j-1]=1;
//                    }else {
//                        s[j-1]=0;
//                    }
//                }
//            }

        }
//        int open=1;
//        for(int i:s){
//            if(i==1){
//                open++;
//            }
//        }
        return open;
    }

}
