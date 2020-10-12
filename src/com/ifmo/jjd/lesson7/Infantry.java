package com.ifmo.jjd.lesson7;

public class Infantry extends BattleUnit {  //пехотинец
    public Infantry(int healthPoints, int agilityPoints, int attackPoints) {
        super(healthPoints, agilityPoints, attackPoints);


    }
        // реализаия метода attack(BattleUnit) интерфеса AttackAble
    @Override
    public void attack(BattleUnit unit) {
        if (this.isAlive() && unit.isAlive() && unit.attackPoints >= this.agilityPoints)
            // 1 если this жив и ловкость unit меньше this
            // unit.health -= this.attack
            // 2 если unit выжил и его ловкость больше this:
            // this.health -= unit.health
            unit.minusHealth(this.attackPoints);
            if (unit.isAlive() && this.isAlive() && unit.agilityPoints >= this.agilityPoints)
                this.minusHealth(unit.attackPoints);



    }
        // реализация метода rest() интерфеса RestAbly
    @Override
    public void rest() {

    }
}
