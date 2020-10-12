package com.ifmo.jjd.lesson7;

public class King extends Unit {
    private int gold = 600;
    private BattleUnit[] army = new BattleUnit[20];

    public King(int healthPoints, int agilityPoints) {
        super(healthPoints, agilityPoints);
    }

    public void plusGold(int gold) {
        if (gold <= 0) {
            return;
        }
        this.gold += gold;

    }

    public void minusGold(int gold) {
        //       if(if (gold <= 0)) return;
        //
        //      if(hasGold() > 0) {this.gold -= gold;
        //      if(!hasGold()) this.gold = 0;

        if (gold > 0 || this.gold >= gold) this.gold -= gold;
    }

    public boolean hasGold() {
        return gold > 0;
    }

    public void generateArmy() {
        // первые три пехотинцы , остальные рыцари (из 20)
        if (this.gold <= 250) return;


        for (int i = 0; i < army.length; i++) {
            army[i] = BattleUnit.unitFactory();


            /* BattleUnit[] : new Knight() / new Infantry() // такое доступно потому что BattleUnit общий тип данных
            BattleUnit battleUnit = new Infantry()
             attack()                     superAttack() // в этом случае будут недоступны особые методы(именно методы)
             attack()                      attack()   // тогда будет доступен переопределенный метод                         */

        }
        minusGold(250);
    }

    public void addUnits() {
        for (int i = 0; i < army.length; i++) {
            if (this.gold >= 20 && !army[i].isAlive()) {
                army[i] = BattleUnit.unitFactory();
                minusGold(20);
            }
        }
    }

    public void startAttack(King enemy) {
        for (int i = 0; i < this.army.length; i++) {
            // усли army[i] - это пехотинец, то атака пехотинца, если рыцарь - то атака рыцаря
            army[i].attack(enemy.army[(int) (Math.random() * (enemy.army.length))]);
            army[i].rest();
        }
    }

    public int getAttackResult() {
        int alive = 0;
        for (BattleUnit unit : army) {
            if (unit.isAlive()) alive++;

        }
        return alive;
    }


    @Override
    public void rest() {
        minusGold(20);
    }


}
