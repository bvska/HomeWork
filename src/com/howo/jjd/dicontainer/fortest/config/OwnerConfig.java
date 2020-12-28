package com.howo.jjd.dicontainer.fortest.config;


import com.howo.jjd.dicontainer.marks.ConfigClass;

@ConfigClass(file = "app.properties", prefix = "owner")
public class OwnerConfig {


    private String ownerName;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "OwnerConfig{" +
                "ownerName='" + ownerName + '\'' +
                '}';
    }
}