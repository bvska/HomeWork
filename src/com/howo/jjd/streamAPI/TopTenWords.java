package com.howo.jjd.streamAPI;

import com.ifmo.jjd.lesson22.Course;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class TopTenWords {
    public static void main(String[] args) throws IOException {
        // создать Map<String, Long> map
        // String - слово
        // Long - частота встречаемости
        // в мапу должны войти только первые 10 частоте встречаемости слов

        // содержимое файла может быть любым
        // Map<String, Long> map = Files.lines(Paths.get("sources/task23.txt")) // читаем из файла в stream
        // методы вызывать по цепочке,
        // цепочку не разрывать (пока не получите результирующую мапу)

        // System.out.println(map);

        Map<String, Long> map = Files.lines(Paths.get("source/task23.txt"))
                .flatMap(s -> Stream.of(s.toLowerCase().split(" ")))
                .map(s -> new String(s))
                .collect(Collectors.toMap(s -> s.toString(), v -> 1L, (v1, v2) -> v1 + v2))
                .entrySet().stream().sorted((s1, s2) ->
                        s2.getValue().compareTo(s1.getValue()))
                .limit(10)
                .collect(Collectors.toMap(k -> k.getKey(), s -> s.getValue()));

        System.out.println(map);
    }
}

