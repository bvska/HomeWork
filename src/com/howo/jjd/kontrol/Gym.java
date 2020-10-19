package com.howo.jjd.kontrol;

import java.util.Arrays;

public class Gym implements AddDel{
    private final  String name = "Тренажерный зал";


    protected Abonement[] gymA = new Abonement[20];



    public String getName() {
        return name;
    }

    @Override
    public void addZal(Abonement ab) {
        for (int i = 0; i < gymA.length; i++) {
            if (gymA[i] == null) {
                gymA[i] = ab;
                System.out.println(Logger.clientInfo(ab, name));
                return;
            }
            if (gymA[gymA.length- 1 ] != null){
                System.out.println("мест нет");
                return;}
        }
    }

    public Boolean test(Abonement ab){
        for (int i = 0; i < gymA.length; i++) {
            if (gymA[i] == ab)
                return true;
        }
        return  false;
    }


    @Override
    public void delZal() {
        for (int i = 0; i < gymA.length; i++) {
            gymA[i] = null;
        }
    }

    @Override
    public void delTimeZal() {
        for (int i = 0; i < gymA.length ; i++) {
            if (gymA[i] instanceof DayAbon)
                gymA[i] = null;
        }
    }

    @Override
    public String toString() {
        return "Gym{" +
                "gyms=" + Arrays.toString(gymA) +
                '}';
    }
}



