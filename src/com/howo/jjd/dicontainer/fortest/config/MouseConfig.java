package com.howo.jjd.dicontainer.fortest.config;


import com.howo.jjd.dicontainer.marks.ConfigClass;

@ConfigClass(file = "app.properties", prefix = "mouse")
public class MouseConfig {
    private String mouseName;
    private int mouseSpeed;

    public String getMouseName() {
        return mouseName;
    }

    public void setMouseName(String mouseName) {
        this.mouseName = mouseName;
    }

    public int getMouseSpeed() {
        return mouseSpeed;
    }

    public void setMouseSpeed(int mouseSpeed) {
        this.mouseSpeed = mouseSpeed;
    }

    @Override
    public String toString() {
        return "MouseConfig{" +
                "mouseName='" + mouseName + '\'' +
                ", mouseSpeed=" + mouseSpeed +
                '}';
    }
}