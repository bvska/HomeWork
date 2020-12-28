package com.howo.jjd.dicontainer;

import com.howo.jjd.dicontainer.fortest.config.MouseConfig;
import com.howo.jjd.dicontainer.marks.RequiredClass;
import com.howo.jjd.dicontainer.marks.RequiredField;



@RequiredClass
public class Mouse {
    @RequiredField
    private MouseConfig mouseConfig;
    private String name;
    private int speed;

    public Mouse() {
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = mouseConfig.getMouseName();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed() {
        this.speed = mouseConfig.getMouseSpeed();
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }
}