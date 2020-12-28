package com.howo.jjd.dicontainer.fortest.config;


import com.howo.jjd.dicontainer.marks.ConfigClass;

@ConfigClass(file = "app.properties", prefix = "cat")
public class CatConfig {
    private String catName;
    private int catSpeed;

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public int getCatSpeed() {
        return catSpeed;
    }

    public void setCatSpeed(int catSpeed) {
        this.catSpeed = catSpeed;
    }

    @Override
    public String toString() {
        return "CatConfig{" +
                "catName='" + catName + '\'' +
                ", catSpeed=" + catSpeed +
                '}';
    }
}