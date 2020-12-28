package com.howo.jjd.dicontainer;

import com.howo.jjd.dicontainer.fortest.config.CatConfig;
import com.howo.jjd.dicontainer.marks.RequiredClass;
import com.howo.jjd.dicontainer.marks.RequiredField;



import java.util.ArrayList;

@RequiredClass
public class Cat {
    @RequiredField
    private CatConfig catConfig;
    private String name;
    private int speed;

    @RequiredField
    private Owner owner;

    private ArrayList<Mouse> mice = new ArrayList<>(20);

    public Cat() {
    }

    public void setName() {
        this.name = catConfig.getCatName();
    }

    public void setSpeed() {
        this.speed = catConfig.getCatSpeed();
    }

    public void catchMouse(Mouse mouse) {
        if (speed < mouse.getSpeed()) {
            System.out.println(mouse.getName() + " убежал от " + name);
            return;
        }
        mice.add(mouse);
        System.out.println(name + " поймал " + mouse.getName());

    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", owner=" + owner +
                ", mice=" + mice +
                '}';
    }
}