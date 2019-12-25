package md5;

import java.security.MessageDigest;

public class MD5 {

    public static void main(String[] args) {
       System.out.println(new MD5().md5("hello"));
    }

    public String md5(String s){
        char hexDigits[]="0123456789abcdef".toCharArray();
        try{
            byte[] btInput=s.getBytes();
            //获取MD5摘要算法的MessageDigest对象
            MessageDigest mdInst=MessageDigest.getInstance("MD5");
            //用指定的字节更新摘要
            mdInst.update(btInput);
            //获取密文
            byte[] md=mdInst.digest();
            //将密文转成十六进制的字符串形式
            int j=md.length;
            char str[]=new char[j*2];
            int k=0;
            for (int i = 0; i < j; i++) {
                byte byte0=md[i];
                str[k++]=hexDigits[byte0>>>4&0xF];
                str[k++]=hexDigits[byte0&0xF];
            }
            return new String(str);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
