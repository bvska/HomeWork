package com.howo.jjd.reflect;

public class UserM {
    public String name = "Vasia";
    public int age = 1;

    public UserM() {

    }

    public UserM(String s, int i){
        name = s;
        age = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printInfo(String name, int age){
        System.out.println("name: " + getName() + ", возраст: " + getAge());
    }

    @Override
    public String toString() {
        return "UserM{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
