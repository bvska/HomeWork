package wlesson5;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        String s = " сом дом домашние тапочки одомашненное животное до домовой посудомойка дом";
        String m = "дом";

        System.out.println(s.split(m, -1).length - 1);

        /*
        String userInfo = "135|bender|bender@gmail.com";
        System.out.println(getUserEmail(userInfo));
        // Вывод: bender@gmail.com
    }

    static String getUserEmail(String userInfo) {
        String[] data = userInfo.split("\\|");
        return data[data.length - 1];
         */
    }
}
