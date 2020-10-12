package com.howo.jjd.task7_dop;

abstract public class HomeAnimal extends Animal {
    protected int health;
    protected int resource;


    public HomeAnimal(String name, int weight, int speed, int health, int resource) {
        super(name, weight, speed);
        if (health < 5 || resource <= 0)
            throw new IllegalArgumentException("health < 5 || resource <=0");
        this.health = health;
        this.resource = resource;
    }

    public void addHealth(int points){
        if (isAlive())
            health +=1;
    }

    public boolean isAlive(){
        return health > 0;
    }

    @Override
    public void run() {

    }
}
