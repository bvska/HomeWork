package com.ifmo.jjd.lesson7;


// extends - наследоваие (множественное наследование запрещено)
// Класс BattleUnit наследует от клаасса Unit
// Класс BattleUnit - дочерний класс
// Класс Unit - родительский класс
// дочерний класс получает доступ ко всем доступным свойствам и методам Unit(родительского класса)
// privet не был бы доступен, и если родительский класс в другом
// пакете то и protected был бы не доступен

abstract public class BattleUnit extends Unit implements AttackAble{
    protected int attackPoints;

    // если есть конструктор без параметров то вызывать необязательно
    // если конструкторов несколько то любой
    // мы обязаны вызвать конструктор родителя так как там был конструктор с параметрами
    // откуда берутся данные не важно

    public BattleUnit(int healthPoints, int agilityPoints, int attackPoints) {
        super(healthPoints, agilityPoints);  // вызов конструктор родителя
        if (attackPoints <= 0)
            throw new IllegalArgumentException("attackPoints <= 0");
        this.attackPoints = attackPoints;
    }


    // класс BattleUnit реализует (имплементирует) интерфейс
    // RestAble и AttackAble, в которых есть методы run с реализацией
    // в такой ситуации мы обязаны явно указать, какой метод выбрать
    @Override
    public void run() {
        System.out.println("реализация run BattleUnit");
    }

    //
    public static BattleUnit unitFactory(){
        String[] types = {"knight", "infantry"};
        BattleUnit unit = null;
        switch (types[(int)(Math.random() * types.length)]){
            case "knight":
                unit = new Knight(
                        (int) (Math.random() * 41) + 10,
                        (int) (Math.random() * 11) + 5,
                        (int) (Math.random() * 11) + 8);
                break;
            case "infantry":
                unit = new Infantry(
                        (int) (Math.random() * 41) + 20,
                        (int) (Math.random() * 11) + 5,
                        (int) (Math.random() * 11) + 5
                    );
                break;
        }
        return unit;
    }


}
