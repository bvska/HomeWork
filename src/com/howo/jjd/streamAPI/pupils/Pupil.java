package com.howo.jjd.streamAPI.pupils;

import java.nio.file.LinkOption;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }
    private int number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;
    private static int count = 1;

    public Pupil(int number, String name, Gender gender, LocalDate birth) {
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public int getAge(){

        return (int)ChronoUnit.YEARS.between(this.getBirth(), LocalDate.now());
    }


    public static Pupil getProduction(){
        String[] nameM = {"Petr", "Alex", "Gorge", "Ivan"};
        String[] nameF = {"Anna", "Ira", "Lena"};
        int a = (int)(Math.random() * 10);
        if (a > 5)
            return new Pupil(count++, nameF[(int)(Math.random() * nameF.length)], Gender.FEMALE,
                    LocalDate.of(2015, 01,01)
                            .minus(Period.ofDays((new Random().nextInt(365 * 10)))));
        else
        return new Pupil(count++, nameM[(int)(Math.random() * nameM.length)], Gender.MALE,
                LocalDate.of(2015, 01,01)
                        .minus(Period.ofDays((new Random().nextInt(365 * 10)))));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pupil)) return false;

        Pupil pupil = (Pupil) o;

        if (number != pupil.number) return false;
        if (name != null ? !name.equals(pupil.name) : pupil.name != null) return false;
        if (gender != pupil.gender) return false;
        return birth != null ? birth.equals(pupil.birth) : pupil.birth == null;
    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }
}
