package com.howo.jjd.patExam;

import java.io.*;

public class Load {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private Game game = new Game();
    private String get;

    protected void nameLoad() {
        try {
            System.out.println("Введите название файла для загрузки:");
            load(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void load(String name) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("source/" + name + ".txt"));
            get = (String) objectInputStream.readObject();
            if (get.equals("fox"))
                game.fox();
            if (get.equals("goInSearch"))
                game.goInSearch();
            if (get.equals("tryToFindOut")) {
                game.tryToFindOut();
            }
            if (get.equals("askOwl")) {
                game.askOwl();
            }
            if (get.equals("askWolf")) {
                game.askWolf();
            }
            if (get.equals("believeOwl")) {
                game.believeOwl();
            }
            if (get.equals("getHoney")) {
                game.getHoney();
            }
            if (get.equals("waitBees")) {
                game.waitBees();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
