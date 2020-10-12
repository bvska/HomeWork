package com.howo.jjd.task7_1;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Petr Petrovich", 39, "География");
        Teacher teacher2 = new Teacher("Ivan Ivanovich", 28, "Информатика");

        Apprentice ania = new Apprentice("Ania", 14, "География", 10);
        Apprentice olia = new Apprentice("Olia", 14, "Информатика", 12);
        Apprentice vasia = new Apprentice("Vasia", 14, "География", 8);
        Apprentice vova = new Apprentice("Vova", 14, "Информатика", 14);
        Apprentice ulia = new Apprentice("Ulia", 14, "ИЗО", 7);

        School klass1 = new School();

        klass1.addApprentices(ania);
        klass1.addApprentices(olia);
        klass1.addApprentices(vasia);
        klass1.addApprentices(vova);
        klass1.addApprentices(ulia);

        klass1.addTeachers(teacher1);
        klass1.addTeachers(teacher2);

        klass1.schoolDay();
        System.out.println(klass1.getInfo());

    }
}
