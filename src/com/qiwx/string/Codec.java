package com.qiwx.string;

import java.util.HashMap;
import java.util.Map;

//TinyURL 的加密与解密
public class Codec {

   static Map<String,String> maps=new HashMap<>();
    public static void main(String[] args) {

    }
    // Encodes a URL to a shortened URL.
    public static String encode(String longUrl) {
        String key=String.valueOf(longUrl.hashCode());
        maps.put(key,longUrl);
       return "http://tinyur.com/"+key;

    }

    // Decodes a shortened URL to its original URL.
    public static String decode(String shortUrl) {
        return maps.get(shortUrl);

    }
}
