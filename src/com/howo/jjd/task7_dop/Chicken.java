package com.howo.jjd.task7_dop;

public class Chicken extends HomeAnimal implements GiveResource, EatResource{

    public Chicken(String name, int weight, int speed, int health, int resource) {
        super(name, weight, speed, health, resource);
    }
}
