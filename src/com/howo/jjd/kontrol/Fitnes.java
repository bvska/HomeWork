package com.howo.jjd.kontrol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;

public class Fitnes {
    BufferedReader nam = new BufferedReader(new InputStreamReader(System.in));
    Gym gymA = new Gym();
    Pool poolA = new Pool();
    GroupLessons grA = new GroupLessons();

    private int k;

    LocalTime endTime = LocalTime.of(22, 00);
    LocalTime startTime = LocalTime.of(8, 00);
    LocalTime dayTime = LocalTime.of(16, 00);
    LocalTime currentTime = LocalTime.now();
    LocalDate currentDate = LocalDate.now();

    public void addFitnes(Abonement ab) throws IOException {
        if (ab.finDate.isBefore(currentDate)){
            System.out.println(ab.getInfoName() + " Ваш абонемент просрочен");
            return;
        }
        if (poolA.test(ab) || grA.test(ab) || gymA.test(ab)){
            System.out.println(ab.getInfoName() + " вы уже зарегестрированы");
            return;}
        if ((currentTime.isAfter(endTime)) || (currentTime.isBefore(startTime))) {
            gymA.delZal();
            poolA.delZal();
            grA.delZal();
            System.out.println("Фитнес не работает");
            return;
        } else if ((currentTime.isAfter(startTime)) && (currentTime.isBefore(dayTime))) {
            if (ab instanceof OneAbon) { oneVizit(ab);}
            if (ab instanceof DayAbon) {dayVizit(ab);}
            if (ab instanceof FullAbon) {fullVizit(ab);}
        }
        else if ((currentTime.isAfter(dayTime)) && (currentTime.isBefore(endTime))){
            grA.delTimeZal();
            gymA.delTimeZal();
            if (ab instanceof OneAbon) { oneVizit(ab);}
            if (ab instanceof DayAbon) {
                System.out.println("недоступное время ваших занятий");
                return;
            }
            if (ab instanceof FullAbon) {fullVizit(ab);}
        }

    }

    private  void fullVizit(Abonement ab) throws IOException {
        System.out.println(ab.getInfoName() + " вы можете посетить бассеин: (1), тренажерный зал: (2), групповые занятия: (3) введите желаемое");
        k = Integer.parseInt(nam.readLine());
        if (k == 1) poolA.addZal(ab);
        else if (k == 2) gymA.addZal(ab);
        else if (k == 3) grA.addZal(ab);
        else {
            System.out.println("Указан недоступный вид тренировки");
        }

    }
    private void oneVizit(Abonement ab) throws IOException {
        System.out.println(ab.getInfoName() + " вы можете посетить бассеин: (1) и тренажерный зал: (2) введите желаемое");
        k = Integer.parseInt(nam.readLine());
        if (k == 1) poolA.addZal(ab);
        else if (k == 2) gymA.addZal(ab);
        else {
            System.out.println("Указан недоступный вид тренировки");
        }
    }
    private void dayVizit(Abonement ab) throws IOException {
        System.out.println(ab.getInfoName() + " вы можете посетить тренажерный зал: (1), и групповые занятия: (2), введите желаемое");
        k = Integer.parseInt(nam.readLine());

        if (k == 1)
            gymA.addZal(ab);
        else if (k == 2)
            grA.addZal(ab);
        else {
            System.out.println("Указан недоступный вид тренировки");
        }
    }

        public void getInfo(){
            System.out.println(Logger.allZalInfo(gymA, poolA, grA));

        }

}
