package com.howo.jjd.lambda;

import java.util.ArrayList;
import java.util.function.*;

public class AppDemo {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
        UnaryOperator<Integer> h = a -> a * a;
        System.out.print(h.apply(i ) + " ");}

        System.out.println(" ");


           Predicate<Integer> isPositive = obj -> obj > 0;
        int[] i = {7, 0, 3, -3, 2, -3, -4, 6, 23, 567};
        for (int j = 0; j < i.length; j++) {
            System.out.print(isPositive.test(i[j]) + " ");}

        System.out.println( " ");
        Predicate<String> test = obj -> "lambda".equals(obj);
        System.out.println(test.test("lam"));
        System.out.println(test.test("lambda"));

        BinaryOperator<Double> sum = (x, y) -> x + y;
        BinaryOperator<Double> div = (x, y) -> {
            if (y == 0) throw new IllegalArgumentException ("делить на 0 нельзя!");
            return x / y;
        };
        System.out.println(div.apply(545.66, 45.0));
        System.out.println(sum.apply(545.66, 45.0));

        Consumer<String> print1 = obj -> System.out.println(obj.toUpperCase());
        print1.accept("hello");
        Consumer<String> print2 = obj -> System.out.println(obj.toLowerCase());
        print1.andThen(print2).accept("Hello world");

        Function<String, Integer> toInt = Integer::valueOf;
    //    Function<String, String> bStr = toInt.andThen(String::valueOf);
        System.out.println((toInt.apply("123")) + 567);
        System.out.println(toInt.apply("123").getClass());
        Function<Integer, String> toStr = obj -> String.valueOf(obj);
        System.out.println(toStr.apply(345).getClass().getSimpleName());


    }

}
