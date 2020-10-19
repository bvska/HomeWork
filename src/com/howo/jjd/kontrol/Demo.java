package com.howo.jjd.kontrol;


import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;

public class Demo {
    public static void main(String[] args) throws IOException {
        Owner aleks = new Owner("Aleks","Petrov", "2000-05-14");
        Owner oleg = new Owner("Oleg","Ivanov", "1990-08-23");
        Owner pavel = new Owner("Pavel","Pavlov", "1997-08-12");

        FullAbon ff = new FullAbon("2020-08-01", "2020-10-30", aleks);
        DayAbon dayA = new DayAbon("2020-08-01", "2020-12-03", oleg);
        OneAbon one = new OneAbon("2020-10-19", "2020-10-19", pavel);

        Fitnes ff2 = new Fitnes();

        ff2.addFitnes(dayA);
        ff2.addFitnes(ff);
        ff2.addFitnes(ff);
        ff2.addFitnes(one);

        ff2.getInfo();
    }
}
