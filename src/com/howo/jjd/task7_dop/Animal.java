package com.howo.jjd.task7_dop;

abstract public class Animal implements RunAble{
    protected String name;
    protected int weight;
    protected int speed;


    public Animal(String name, int weight, int speed) {
        if (name.trim().length() < 3 || weight < 3 || speed < 2 )
            throw new IllegalArgumentException("name.trim().length() < 3 || weight < 3 || speed < 2");
        this.name = name;
        this.weight = weight;
        this.speed = speed;

    }

    @Override
    public void run(Animal animal) {
        if (animal.speed > this.speed)


    }
}
