package com.qiwx.queue;

import java.util.LinkedList;
import java.util.Queue;

//无重复字符的最长子串
public class LongestSubstring {
    public static void main(String[] args) {
        //System.out.println(lengthOfLongestSubstring(" "));
        //System.out.println(lengthOfLongestSubstring("abcabcbb"));
        // System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(""));
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxlen=0;
        char [] chars=s.toCharArray();
        Queue<Character> queues=new LinkedList<>();
        for(int i=0;i<chars.length;i++){
            if(queues.isEmpty()){
                queues.offer(chars[i]);
            }else{
                if(!queues.contains(chars[i])){
                    queues.offer(chars[i]);
                }else{
                    maxlen=maxlen<queues.size()?queues.size():maxlen;
                    while (queues.peek().charValue()!=chars[i]) {
                        queues.poll();
                    }
                    queues.poll();
                    queues.offer(chars[i]);
                }
            }
        }
        return maxlen>queues.size()?maxlen:queues.size();

    }
}
