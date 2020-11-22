package com.howo.jjd.streamAPI.pupils;


import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class PupilTask {
    public static void main(String[] args) {

        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль


        ArrayList<Pupil> pupils = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            pupils.add(Pupil.getProduction());

        }


        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>

        Map<Pupil.Gender, ArrayList<Pupil>> genderMap = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));

        System.out.println(genderMap);

        // 2. Найти средний возраст учеников


       Double ageAver = pupils.stream().mapToLong(Pupil::getAge).average().getAsDouble();
        System.out.println(ageAver);

        // 3. Найти самого младшего ученика

        Pupil minP = pupils.stream().min(Comparator.comparing(Pupil::getAge)).get();
        System.out.println(minP);

        // 4. Найти самого старшего ученика

        Pupil maxP = pupils.stream().max(Comparator.comparing(Pupil::getAge)).get();
        System.out.println(maxP);

        // 5. Собрать учеников в группы по году рождения

        Map<LocalDate, List<Pupil>> birthGroup = pupils.stream().collect(Collectors.groupingBy(Pupil::getBirth));
        System.out.println(birthGroup);

        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль

        Map<String, Pupil> nameU = pupils.stream().distinct()
                .collect(Collectors.toMap(Pupil::getName, Function.identity(), (n1, n2)->n2))
                .entrySet()
                .stream()
                .peek(s -> System.out.println(s.getValue().getName() + " " + s.getValue().getBirth()))
                .collect(Collectors.toMap(s->s.getKey(), d -> d.getValue()));

        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)

        List<Pupil> list = pupils.stream().sorted(Comparator.comparing(Pupil::getName))
                .sorted(Comparator.comparing(Pupil::getGender))
                .sorted(Comparator.comparing(Pupil::getName).reversed())
                .collect(Collectors.toList());

        // 8. Вывести в консоль всех учеников в возрасте от N до M лет
        Stream<Pupil> list1 = pupils.stream();
         list1.filter(s -> (s.getAge() > 9))
                .filter(s -> (s.getAge() < 12)).forEach(System.out::println);


        // 9. Собрать в список всех учеников с именем=someName


        List<Pupil> pupilsIra = pupils.stream().filter(s -> s.getName().equals("Ira")).collect(Collectors.toList());
        System.out.println(pupilsIra);

        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола

        Map<Pupil.Gender, Double> mapG = pupils.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.averagingInt(s -> (int)s.getAge())));
        System.out.println(mapG);

    }
}
