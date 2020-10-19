package com.howo.jjd.kontrol;

import java.time.LocalDate;
import java.time.LocalTime;


 abstract public class Abonement {
    protected LocalDate regDate;
    protected LocalDate finDate;
    protected Owner owner;

    public Abonement(String regD, String finD, Owner owner) {

        regDate = LocalDate.parse(regD);
        finDate = LocalDate.parse(finD);
        if (owner == null)
            throw new IllegalArgumentException("у абонемента должен быть владелец");
        if (finDate.isBefore(regDate))
            throw new IllegalArgumentException("дата регистрации должна быть раньше даты окончания");
        this.owner = owner;


    }
    public String getInfoName (){
        return owner.getName();
    }

    public String getInfoFname(){
        return owner.getFName();
    }

     @Override
     public String toString() {
         return "{" +
                 "Начало регистрации=" + regDate +
                 ", конец регистрации=" + finDate +
                 "," + owner +
                 '}';
     }
 }
