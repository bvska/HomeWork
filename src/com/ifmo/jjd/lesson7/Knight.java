package com.ifmo.jjd.lesson7;

public class Knight extends BattleUnit{  // рыцарь
    private final int additionAttack = 2;
    public Knight(int healthPoints, int agilityPoints, int attackPoints) {
        super(healthPoints, agilityPoints, attackPoints);
    }

        @Override
        public void attack(BattleUnit unit) {
            if (this.isAlive() && unit.isAlive() && unit.attackPoints >= this.agilityPoints)
                // 1 если this жив и ловкость unit меньше this
                // unit.health -= this.attack
                // 2 если unit выжил и его ловкость больше this:
                // this.health -= unit.health
                unit.minusHealth(this.attackPoints + additionAttack);
                if (unit.isAlive() && this.isAlive() && unit.agilityPoints >= this.agilityPoints)
                    this.minusHealth(unit.attackPoints);



        }


        @Override
        public void rest() {

        }


}
