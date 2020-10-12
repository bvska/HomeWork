package com.ifmo.jjd.lesson7;
// возможность атаковать


public interface AttackAble {
    // метод без реализации
    void attack(BattleUnit unit); // общий тип данных, может атаковать только боевых юнитов

    // метод с реализацией
    default void run(){
        System.out.println("run AttackAble");
    }

}
