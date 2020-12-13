package com.howo.jjd.patExam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    private Menu menu;
    private User user;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int i;


    public Start() {
        menu = new Menu();
        user = new User(new StartCommand(menu), new ExitCommand(menu), new LoadCommand(menu));
        System.out.println("Введите 1, если хотите начать игру.");
        System.out.println("Введите 2 если хотите загрузить игру.");
        System.out.println("Введите 3, если хотите выйти.");
        try {
            i = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (i == 1) user.startGame();
        if (i == 2) user.loadGame();
        if (i == 3) user.exitGame();
    }


}
