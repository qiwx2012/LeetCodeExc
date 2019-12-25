package com.qiwx.string;

import java.util.*;

// 串联所有单词的子串
public class FindSubstring {
    public static void main(String[] args) {
     List<Integer> list= new FindSubstring().findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"});
//     List<Integer> list= new FindSubstring().findSubstring("barfoothefoobarman",new String[]{"foo","bar"});
//     List<Integer> list= new FindSubstring().findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",new String[]{"fooo","barr","wing","ding","wing"});
//     List<Integer> list= new FindSubstring().findSubstring("aaa",new String[]{"aa","aa"});
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new LinkedList<>();
        if (words == null || words.length == 0)
            return list;
        HashMap<String, Integer> map1 = new HashMap();
        for (int i = 0; i < words.length; i++) {
            if(map1.containsKey(words[i])){
                map1.put(words[i],(map1.get(words[i]).intValue()+1));
            }else {
                map1.put(words[i],1);
            }
        }
        int wordLen = words[0].length();
        int nums = words.length;//匹配次数
        for (int i = 0; i < s.length() - wordLen *nums +1; i++) {
            int j = 0;
            int start = i;
            Map<String, Integer> map=new HashMap();
            map.putAll(map1);
            while (j < nums) {
                String key = s.substring(start, start + wordLen);
                if(map.containsKey(key)){
                  int num= map.get(key).intValue();
                  if(num>0){
                      map.put(key,(--num));
                  }else {
                      break;
                  }
                }else {
                    break;
                }
                start = start+wordLen;
                j++;

            }
            if(j==nums){
                list.add(i);
            }
        }
        return list;

    }
}
