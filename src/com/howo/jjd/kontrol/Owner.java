package com.howo.jjd.kontrol;

import java.time.LocalDate;

public class Owner {
    private String name;
    private String fName;
    private LocalDate date1;

    public Owner(String name, String fName, String date) {
        date1 = LocalDate.parse(date);
        setDate(date);
        setFName(fName);
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.trim().length() < 3)
            throw new IllegalArgumentException("должна быть написано Имя");
        this.name = name;
    }

    public String getFName() {
        return fName;
    }

    private void setFName(String fName) {
        if (fName.trim().length() < 3)
            throw new IllegalArgumentException("должна быть написана Фамилия");
        this.fName = fName;
    }

    public LocalDate getDate() {
        return date1;
    }

    private void setDate(String date2) {
        LocalDate someDate = LocalDate.of(2002, 10, 15);
        LocalDate tmp = LocalDate.parse(date2);
        if (someDate.isBefore(date1))
            throw new IllegalArgumentException("посетитель не может быть моложе 18 лет, или поле должно быть заполнено");
        this.date1 = tmp;
    }




    @Override
    public String toString() {
        return "Владелец: {" +
                "Имя: " + name + '\'' +
                ", Фамилия: " + fName + '\'' +
                ", Д.Р.: " + date1 +
                '}';
    }
}
