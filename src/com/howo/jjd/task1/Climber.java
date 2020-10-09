package com.howo.jjd.task1;

public class Climber {
    private String nameClimber;
    private String addressClimber;

    public Climber(String nameClimber, String addressClimber) {
        setNameClimber(nameClimber);
        setAddressClimber(addressClimber);
    }

    public String getNameClimber() {
        return nameClimber;
    }

    public void setNameClimber(String nameClimber) {
        if (nameClimber == null || nameClimber.trim().length() < 3)
            throw new IllegalArgumentException("имя должно быть больше 3х символов");
        this.nameClimber = nameClimber;
    }

    public String getAddressClimber() {
        return addressClimber;
    }

    public void setAddressClimber(String addressClimber) {
        if (addressClimber == null ||  addressClimber.trim().length() < 5)
            throw new IllegalArgumentException("адрес проживания не может быть пустым или коротким");
        this.addressClimber = addressClimber;
    }



}
