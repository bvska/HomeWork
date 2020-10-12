package com.ifmo.jjd.lesson7;

public class Aplication {
    public static void main(String[] args) {
        King king1 = new King(100, 10);
        King king2 = new King(100, 15);

        king1.generateArmy();
        king2.generateArmy();

        king1.startAttack(king2);

        System.out.println(king1.getAttackResult());
        System.out.println("армия 2го короля: " + king2.getAttackResult());


        king2.startAttack(king1);
        System.out.println(king1.getAttackResult());
        System.out.println("армия 2го короля: " + king2.getAttackResult());
        
        king1.addUnits();
        System.out.println(king1.getAttackResult());
    }

}
