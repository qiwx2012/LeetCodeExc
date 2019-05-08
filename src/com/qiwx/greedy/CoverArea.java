package com.qiwx.greedy;

import java.util.*;

//覆盖地区
public class CoverArea {
    public static void main(String[] args) {
        HashMap<String,HashSet<String>> broadcasts=new HashMap<>();
        broadcasts.put("k1",new HashSet<>(Arrays.asList(new String[]{"ID","NV","UT"})));
        broadcasts.put("k2",new HashSet<>(Arrays.asList(new String[]{"WA","ID","MT"})));
        broadcasts.put("k3",new HashSet<>(Arrays.asList(new String[]{"OR","NV","CA"})));
        broadcasts.put("k4",new HashSet<>(Arrays.asList(new String[]{"NV","UT"})));
        broadcasts.put("k5",new HashSet<>(Arrays.asList(new String[]{"CA","AZ"})));
        //需要覆盖的全部地区
        HashSet<String> allAreas=new HashSet<>(Arrays.asList(new String[]{"ID","NV","UT","WA","MT","OR","CA","AZ"}));
        //所选择的广播平台
        List<String> selects=new ArrayList<>();
        HashSet<String> tempSet=new HashSet<>();
        String maxKey=null;
        while (allAreas.size()>0){
            maxKey=null;
            for(String key:broadcasts.keySet()){
                tempSet.clear();
                HashSet<String> areas=broadcasts.get(key);
                tempSet.addAll(areas);
                //求出两个集合的交集
                tempSet.retainAll(allAreas);
                //如果该集合包含的地区数量比原本集合多
                if(tempSet.size()>0&&(maxKey==null||tempSet.size()>broadcasts.get(maxKey).size()))
                {
                    maxKey=key;
                }
            }
            if(maxKey!=null){
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }
        for(String ll:selects){
            System.out.println("广播"+ll);
        }




    }

}
