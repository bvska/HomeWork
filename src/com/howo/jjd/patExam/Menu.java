package com.howo.jjd.patExam;


//reciver
public class Menu {

    protected void start() {
        Game game = new Game();
        game.fox();
    }

    protected void exit() {
        System.out.println("Пока");
    }

    protected void loadGame() {
        Load load = new Load();
        load.nameLoad();
    }
}
