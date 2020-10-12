package com.howo.jjd.task7_dop;

abstract public class WildAnimal extends Animal{

    protected int force;

    public WildAnimal(String name, int weight, int speed, int force) {
        super(name, weight, speed);
        this.force = force;
    }

    @Override
    public void run() {

    }
}
