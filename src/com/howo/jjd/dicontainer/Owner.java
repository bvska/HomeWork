package com.howo.jjd.dicontainer;


import com.howo.jjd.dicontainer.fortest.config.OwnerConfig;
import com.howo.jjd.dicontainer.marks.RequiredClass;
import com.howo.jjd.dicontainer.marks.RequiredField;



@RequiredClass
public class Owner {
    @RequiredField
    private OwnerConfig ownerConfig;
    private String name;

    public Owner() {
    }

    public void setName() {
        this.name = ownerConfig.getOwnerName();
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                '}';
    }
}