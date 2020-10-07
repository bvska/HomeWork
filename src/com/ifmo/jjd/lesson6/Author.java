package com.ifmo.jjd.lesson6;

public class Author {
    private String name;
    private String surname;

    // если мы создали контруктор,  то потеряли возможность обращаться к конструктору по умолчанию,
    // поэтмоу если он нам нужен. то нам его необходимо создать
    // конструктор
    //  Author() - вызов конструктора по умолчанию, без аргументов
    // данный конструктор принимает на вход строку и устанавливает значение
    public Author(){

    }

    public Author(String name){
        setName(name);  // проверка
        //this.name = name;
    }
    // это тоже конструктор, но уже с 2мя значениями
    public Author(String name, String surname){
        setSurname(name);
        setName(surname);
        //this.name = name;
       // this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.trim().length() < 3)
            throw new IllegalArgumentException("title должен быть не меньше 3");
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3)
            throw new IllegalArgumentException("title должен быть не меньше 3");
        this.name = name;
    }

    public  String getFullname(){
        return name + " " + surname;
    }

    public String getFullName(String name, String surname){
        return name + " " + surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
    //
}
