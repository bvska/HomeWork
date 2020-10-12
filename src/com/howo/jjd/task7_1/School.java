package com.howo.jjd.task7_1;


import java.util.Arrays;

public class School {
    private final static String name = "Kolobok";
    private Director director = new Director("S.P.", 50);

    private Apprentice[] apprentices = new Apprentice[5];
    private Teacher[] teacher = new Teacher[2];

    public void addApprentices(Apprentice klass) {
        for (int i = 0; i < apprentices.length; i++) {
            if (apprentices[i] == null) {
                apprentices[i] = klass;
                return;
            }
        }
    }

    public void addTeachers(Teacher ome) {
        for (int i = 0; i < teacher.length; i++) {
            if (teacher[i] == null) {
                teacher[i] = ome;
                return;
            }
        }
        System.out.println(Arrays.toString(teacher));
    }

    public void schoolDay() {

        director.startOfClasses();

        for (int i = 0; i < teacher.length; i++) {
            for (int j = 0; j < apprentices.length; j++) {
                if (teacher[i].getSchoolSubject() == apprentices[j].getSchoolSubject()) {
                    teacher[i].teach(apprentices[j]);
                }
            }
        }
        director.endOfClasses();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Школа: ").append(name).append(" Директор школы: ").append(director.name).append("\n");
        sb.append("Учителя: \n");
        for (Teacher group: teacher) {
            if (group != null) sb.append(group.getName())
                    .append(" Предмет: ")
                    .append(group.getSchoolSubject())
                    .append("\n");
            
        }
        sb.append("Ученики: \n");
        for (Apprentice klass: apprentices) {
            if (klass != null)
            sb.append(klass.getName()).append(" Предмет: ")
                    .append(klass.getSchoolSubject())
                    .append(" Уровень знаний: ")
                    .append(klass.getKnowledgeLevel()).append("\n");
        }

        return sb.toString();
    }

}
