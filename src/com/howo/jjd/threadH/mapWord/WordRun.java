package com.howo.jjd.threadH.mapWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordRun implements Runnable {

    private static ArrayList<ArrayList<String>> lists;
    private Map<String, Integer>  map;
    private static Map<String, Integer>  mapAll = new HashMap<>();
    private ArrayList<String> arrayList;

    public static Map<String, Integer> getMapAll() {
        return mapAll;
    }

    public WordRun(ArrayList<ArrayList<String>> lists) {
        this.lists = lists;
    }

    @Override
    public  void run() {
        synchronized (lists){
       map = this.getList(lists).stream()
               .collect(Collectors.toMap(s -> s.toString(), v -> 1, (v1, v2) -> v1 + v2));
     WordRun.getMap(map);

    }}

    private static  Map<String, Integer> getMap(Map<String, Integer> map){
                for (Map.Entry<String, Integer> pair : map.entrySet()) {
            int i = pair.getValue();
            if (mapAll.containsKey(pair.getKey())){
                i = 2 * i;
                mapAll.put(pair.getKey(),  i);
            }
            else
            mapAll.put(pair.getKey(), pair.getValue());
        }
                return mapAll;
    }

    private ArrayList<String> getList (ArrayList<ArrayList<String>> lists){
         arrayList = new ArrayList<>(lists.get(0));
        lists.remove(0);
        return arrayList;
    }
}
