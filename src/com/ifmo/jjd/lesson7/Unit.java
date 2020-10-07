package com.ifmo.jjd.lesson7;

public class Unit {
    protected int healthPoints;
    protected int agilityPoints;

    protected int maxHealth;


    // конструктор, создаем юнитов с определенными характеристиками
    public Unit(int healthPoints, int agilityPoints) {
        this.healthPoints = healthPoints;
        this.agilityPoints = agilityPoints;
    }

    // базовые методы изменения характеритик здоровья
    public void plusHealth(int points){
        if (isAlive()){
            healthPoints += points;
        else if (maxHealth > 20)
            healthPoints = maxHealth;}
    }

    public void minusHealth(int points){
        if(isAlive()) {
            healthPoints -= points;
            if (healthPoints > maxHealth) healthPoints = maxHealth;
        }
    }

    // проверяем жив ли персонаж
    public boolean isAlive(){
        // оператор всегд авернет нужное значание
        return healthPoints > 0;
    }

}
