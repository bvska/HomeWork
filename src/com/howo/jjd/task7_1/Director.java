package com.howo.jjd.task7_1;

public class Director extends People{
    public Director(String name, int age) {
        super(name, age);
    }

    public void startOfClasses(){
        System.out.println("начало занятий");

    }

    public void endOfClasses(){
        System.out.println("конец занятий");

    }
}
