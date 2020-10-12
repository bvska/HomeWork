package com.howo.jjd.task7_1;

public class Apprentice extends People implements StudyAble {
    protected String schoolSubject;
    protected int knowledgeLevel;

    public Apprentice(String name, int age, String schoolSubject, int knowledgeLevel) {
        super(name, age);
        if (schoolSubject.trim().length() < 3 || knowledgeLevel <=0)
            throw new IllegalArgumentException("у предмета должно быть название или knowledgeLevel <=0");
        this.schoolSubject = schoolSubject;
        this.knowledgeLevel = knowledgeLevel;
    }

    public int getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public String getSchoolSubject(){
        return schoolSubject;
    }


    @Override
    public void study() {
        knowledgeLevel++;
    }
}
