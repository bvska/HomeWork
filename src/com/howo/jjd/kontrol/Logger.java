package com.howo.jjd.kontrol;

import java.time.LocalDate;
import java.time.LocalTime;

public class Logger {
    public static String clientInfo(Abonement ab, String name){
        StringBuilder sb = new StringBuilder();
        sb.append("Фамилия: ")
                .append(ab.getInfoFname())
                .append(" Имя: ")
                .append(ab.getInfoName())
                .append(" Посещаемая зона: ")
                .append(name)
                .append(" Время посещения: ")
                .append(LocalTime.now())
                .append(" Дата посещения: ")
                .append(LocalDate.now());
        return sb.toString();
    }

    public static String allZalInfo(Gym gymA, Pool poolA, GroupLessons grA){
        StringBuilder sb = new StringBuilder();
        sb.append(gymA.getName()).append(": \n");
        for (int i = 0; i < gymA.gymA.length; i++) {
            if (gymA.gymA[i] != null)
                sb.append("Посетитель: ")
                        .append(gymA.gymA[i].getInfoName())
                        .append(" ")
                        .append(gymA.gymA[i].getInfoFname())
                        .append("\n");

        }
        sb.append(poolA.getName()).append(": \n");
        for (int i = 0; i < poolA.poolA.length; i++) {
                if (poolA.poolA[i] != null)
                   sb.append("Посетитель: ")
                .append(poolA.poolA[i].getInfoName())
                .append(" ")
                .append(poolA.poolA[i].getInfoFname())
                .append("\n");

        }
        sb.append(grA.getName()).append(": \n");
        for (int i = 0; i < grA.grA.length; i++) {
            if (grA.grA[i] != null)
                sb.append("Посетитель: ")
                        .append(grA.grA[i].getInfoName())
                        .append(" ")
                        .append(grA.grA[i].getInfoFname())
                        .append("\n");

        }
        return sb.toString();
    }


}
