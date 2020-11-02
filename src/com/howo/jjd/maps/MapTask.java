package com.howo.jjd.maps;

import com.howo.jjd.maps.Customer;

import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который приннимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

       // System.out.println(requestCity(firstTaskMap, city));



        // TODO:: дан список слов (words). Написать метод, который будет возвращать количество одинаковых слов с списке
        //  в виде Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

     //   System.out.println(addWord(words));


        // TODO:: дана мапа (customerMap).
        //  Написать метод, который принимает на вход агрументы int from и int to и возвращает новую мапу,
        //  в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));



        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";
        System.out.println(frequencyWord(text));
    }


    public static HashMap<String, Customer> addUser(HashMap<String, Customer> customerMap, int from, int to){
        HashMap<String, Customer> m = new HashMap<>();
        for (Map.Entry<String, Customer> s : customerMap.entrySet()) {

            if ((s.getValue().getAge() >= from) && (s.getValue().getAge() <= to))
               m.put(s.getKey(), s.getValue());
        }
        return m;
    }

    public static List<String> requestCity(HashMap<String, String> firstTaskMap, String city) {
        List<String> cityList = new LinkedList<>();
        for (HashMap.Entry<String, String> pair : firstTaskMap.entrySet()) {
            if (pair.getValue().equals(city)) {
            cityList.add(pair.getKey());
            }

        }
        return cityList;
    }

    public static HashMap<String, Integer> addWord(List<String> words){
        HashMap<String, Integer> wordsMap = new HashMap<>();
        int count = 0;
        // заполняем мапу значениями
        for (String s: words) {
            wordsMap.put(s, count);

        }
        // а тут уже считаем значения
        for (HashMap.Entry<String, Integer> pair : wordsMap.entrySet()) {
            count = pair.getValue();
            for (String s: words) {
                 if (pair.getKey().equals(s)){
                    count++;
                    wordsMap.put(pair.getKey(), count);
                }
            }
        }
     return wordsMap;
    }

    public static int addText(String s, String word){
        String[] s1 = s.split(" ", -1);
        int nam = 0;
        for (String s2 : s1) {
            if (word.equalsIgnoreCase(s2)) nam++;
        }
        return nam;
    }

    public static HashMap<Integer, LinkedList<String>> groupWords(String s){
        HashMap<Integer, LinkedList<String>> groupW = new HashMap<>();
        HashSet<Integer> groupW1 = new HashSet<>();
        String[] s1 = s.split(" ", -1);
        for (String s2 : s1) {
            groupW1.add(s2.length());
        }
        System.out.println(groupW1);
        for (Integer num : groupW1) {
            LinkedList<String> word = new LinkedList<>();
            for (String s2 : s1) {
                if(num == s2.length())
                    word.add(s2);
                }
            groupW.put(num, word);
        }
        return groupW;
    }

    public static HashMap<String, Integer> frequencyWord(String s) {
        HashMap<String, Integer> frequencyWords = new HashMap<>();
        HashMap<String, Integer> frequencyWords1 = new HashMap<>();
        String[] s1 = s.toLowerCase().split(" ");
        int count = 0;
        for (String s2 : s1) {
            frequencyWords.put(s2, count);
        }
        frequencyWords.putAll(addMap(frequencyWords, s1));

        for (int i = 0; i < 10; i++) {
            String s3 = null;
            int m = 0;
            for (HashMap.Entry<String, Integer> pair : frequencyWords.entrySet()) {
                if (m <= pair.getValue()){
                    m = pair.getValue();
                    s3 = pair.getKey();}
            }
           frequencyWords1.put(s3, m);
           frequencyWords.remove(s3, m);

        }
            return frequencyWords1;
    }

    public static HashMap<String, Double> letter(String s){
        HashMap<String, Double> letterMap = new HashMap<>();
        HashMap<String, Integer> letterMap1 = new HashMap<>();
        String[] s1 = s.replaceAll("\\s+", "").toLowerCase().split("");
        int count = 0;
        double m = s1.length;
        for (String s2: s1) {
            letterMap1.put(s2, count);
        }

        letterMap1.putAll(addMap(letterMap1, s1));

        for (HashMap.Entry<String, Integer> pair : letterMap1.entrySet()) {
            letterMap.put(pair.getKey(), (pair.getValue() * 100 / m));
        }
        return letterMap;
    }

    public static HashMap<String, Integer> addMap(HashMap<String, Integer> pairAll, String[] s5){
        HashMap<String, Integer> nullMap = pairAll;
        for (HashMap.Entry<String, Integer> pair : nullMap.entrySet()) {
            int i = pair.getValue();
            for (String s2: s5) {
                if (pair.getKey().equals(s2)){
                    i++;
                    nullMap.put(pair.getKey(), i);
                }
            }
        }
        System.out.println(nullMap);
        return nullMap;
    }
}

