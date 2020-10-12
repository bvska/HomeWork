package com.howo.jjd.task7_1;

public class Teacher extends People implements TeachAble{
    protected String schoolSubject;


    public Teacher(String name, int age, String schoolSubject) {
        super(name, age);
        if (schoolSubject.trim().length() < 3)throw new IllegalArgumentException("у предмета должно быть название");
        this.schoolSubject = schoolSubject;
    }

    public String getSchoolSubject(){
        return schoolSubject;
    }



    @Override
    public String toString() {
        return "Teacher{" +
                "schoolSubject='" + schoolSubject + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void teach(Apprentice apprentice) {
        apprentice.study();

    }
}
