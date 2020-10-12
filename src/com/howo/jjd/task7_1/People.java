package com.howo.jjd.task7_1;

abstract public class People {
    protected String name;
    protected int age;


    public People(String name, int age) {
        if (name.trim().length() < 3 || name == null || age < 7)
            throw new IllegalArgumentException("name.trim().length() < 3 || name == null || age < 7");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
