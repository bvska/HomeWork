package com.ifmo.jjd.lesson7;


// класс Unit имплементирует интерфейс RestAble соответственно обязан реализовать
// все методы без реализации данного интерфейса
//  либо класс должен быть абстрактным (abstract)

// abstract класс могут содержать методы без реализации
//abstract  класс могут содержать методы с реализацией
// на основе abstract класса нельзя создать объект (new Unit())


abstract  public class Unit implements RestAble {
    protected int healthPoints;
    protected int agilityPoints;

    protected final int maxHealth;


    // конструктор, создаем юнитов с определенными характеристиками
    public Unit(int healthPoints, int agilityPoints) {
        if(healthPoints <= 0 || agilityPoints  <= 0) {throw new IllegalArgumentException("healthPoints < 0 || agilityPoints  < 0");}
        maxHealth = healthPoints;
        this.healthPoints = healthPoints;
        this.agilityPoints = agilityPoints;
    }

    // базовые методы изменения характеритик здоровья
    public void plusHealth(int points){
        if (isAlive()){
            healthPoints += points;}
        else if (healthPoints > maxHealth) healthPoints = maxHealth;

    }

    public void minusHealth(int points){
        if(isAlive()) {
            healthPoints -= points;
            if (healthPoints < 0) healthPoints = 0;
        }
    }

    // проверяем жив ли персонаж
    public boolean isAlive(){
        // оператор всегд авернет нужное значание
        return healthPoints > 0;
    }

}
