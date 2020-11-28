package com.howo.jjd.threadH.mapWord;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapWord{

    public static void main(String[] args) {

       ArrayList<String> list = new ArrayList<>();
        try {
            list = (ArrayList<String>) Files.lines(Paths.get("source/task23.txt"))
                        .flatMap(s -> Stream.of(s.toLowerCase().split(" ")))
                        .map(s -> new String(s))
                        .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }



        ArrayList<Thread> tasks = new ArrayList<>();
        WordRun map = new WordRun(MapWord.getArr(list));
        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            tasks.add(new Thread(map));
        }
        for (Thread task : tasks) {
            task.start();
        }
        for (Thread task : tasks) {
            try {
                task.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        System.out.println(map.getMapAll().entrySet().stream().sorted((s1, s2) ->
                s2.getValue().compareTo(s1.getValue()))
                .limit(2)
                .collect(Collectors.toMap(k -> k.getKey(), s -> s.getValue())));

    }

    public static ArrayList<ArrayList<String>> getArr(ArrayList<String> list){
        ArrayList<ArrayList<String>>  listAll = new ArrayList<>();
        int i = list.size() / Runtime.getRuntime().availableProcessors();
        for (int j = 0; j < Runtime.getRuntime().availableProcessors(); j++) {
            ArrayList<String> list2 = new ArrayList<>();
            ArrayList<String> list1 = new ArrayList<>();

            if (j < Runtime.getRuntime().availableProcessors() - 1){
                list2 = (ArrayList<String>) list.stream()
                        .skip(j * i).collect(Collectors.toList());
                list1 = (ArrayList<String>) list2.stream().limit(i).collect(Collectors.toList());
                listAll.add(list1);
            }
            else {
                list2 = (ArrayList<String>) list.stream()
                        .skip(j * i).collect(Collectors.toList());
                listAll.add(list2);}
        }
        return listAll;
    }

}
