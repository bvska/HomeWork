package com.howo.jjd.patExam;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalTime;


public class SaveGame {

    static void save(String game) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("source/" + LocalTime.now().getHour() + "" + LocalTime.now().getMinute()
                    + "" +  LocalTime.now().getSecond() + ".txt"));
            objectOutputStream.writeObject(game);
            objectOutputStream.close();
            // вариант,  после сохранения мы продолжаем игру
            // return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
