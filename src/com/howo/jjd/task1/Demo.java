package com.howo.jjd.task1;

public class Demo {
    public static void main(String[] args) {
        Climber vasia = new Climber("Vasia", "Pskov");
        Climber petia = new Climber("Petia", "Novgorod");
        Climber tema = new Climber("Tema", "Kirov");
        Climber boria = new Climber("Boria", "Kirov");
        Climber ania = new Climber("Ania", "Kursk");
        Climber olia = new Climber("Olia", "Kirov");
        Climber vova = new Climber("Vova", "Pskov");



        Mountain kavkaz = new Mountain("Kavkaz", "Russia", 5200);
        Mountain ural = new Mountain  ("Ural", "Russia", 3000);


        BunchOfClimbers group = new BunchOfClimbers(3, false, kavkaz);
        BunchOfClimbers group1 = new BunchOfClimbers(2, true, ural);
        BunchOfClimbers group2 = new BunchOfClimbers(2, true, kavkaz);

        group.addBunchOfClimber(vasia);
        group.addBunchOfClimber(petia);
        group.addBunchOfClimber(tema);
        group1.addBunchOfClimber(ania);
        group1.addBunchOfClimber(olia);
        group2.addBunchOfClimber(boria);
        group2.addBunchOfClimber(vova);
        System.out.println("Группа1: " + group.getInfo());
        System.out.println("Группа2: " + group1.getInfo());
        System.out.println("Группа3: " + group2.getInfo());
    }
}
