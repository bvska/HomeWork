package com.howo.jjd.lambda.car;



import java.util.Comparator;
import java.util.TreeSet;

public class CarSort {

    public static void main(String[] args) {

        // сортировать по значениям свойств: price, color, brand


        Car blackOpel = new Car("black", "opel", 2000);
        Car redOpel = new Car("red", "opel", 2500);
        Car yellowMazda = new Car("yellow", "mazda", 3000);
        Car greenMazda = new Car("green", "mazda", 3000);
        Car greenMerc = new Car("green", "mercedes", 3000);





        Comparator<Car> byCar = (c1, c2) -> Integer.compare(c1.getPrice(), c2.getPrice());
        Comparator<Car> byColor = (c1, c2) -> c1.getColor().compareTo(c2.getColor());
        Comparator<Car> byBrend = Comparator.comparing(Car::getBrand);
        TreeSet<Car> carTreeSet = new TreeSet<>(byCar.thenComparing(byColor).thenComparing(byBrend));



        carTreeSet.add(blackOpel);
        carTreeSet.add(redOpel);
        carTreeSet.add(yellowMazda);
        carTreeSet.add(greenMazda);
        carTreeSet.add(greenMerc);

        System.out.println(carTreeSet);
    }
}