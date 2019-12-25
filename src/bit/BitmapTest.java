package bit;

import java.util.HashMap;
import java.util.Map;

//位图数据数据结构
public class BitmapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Bitmap bitmap = new Bitmap(365);
        System.out.println(3 << 0);
        System.out.println(3 << 2);


        for (int i = 1; i <= 365; i++) {
            //System.out.println(i>>3);
            bitmap.set(i, i % 2 == 0);

            //System.out.println(i+":"+get2BitString(i));
//            String key=get2BitString(i);
//            if(!map.containsKey(key)){
//                map.put(key,i);
//            }else {
//                System.out.println("重复key："+key+"value:"+i);
//            }
        }
        System.out.println(bitmap.get(20));

    }

    //获取二进制字符串
    private static String get2BitString(int num) {
        StringBuilder sb = new StringBuilder();
        //每次都与1与操作，获取最后一位值
        while (num > 0) {
            sb.append(num & 1);
            num = num >> 1;
        }
        return sb.toString();

    }
}
