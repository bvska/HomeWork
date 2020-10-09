package com.howo.jjd.task1;

public class Mountain {
    private String nameMountain;
    private String countryMountain;
    private int heightMountain;

    public Mountain(String nameMountain, String countryMountain, int heightMountain) {
        setCountryMountain(countryMountain);
        setHeightMountain(heightMountain);
        setNameMountain(nameMountain);
    }

    public String getNameMountain() {
        return nameMountain;
    }

    public void setNameMountain(String nameMountain) {
        if (nameMountain == null || nameMountain.trim().length() < 4)
            throw new IllegalArgumentException("название не может быть коротким или пустым");
        this.nameMountain = nameMountain;
    }

    public String getCountryMountain() {
        return countryMountain;
    }

    public void setCountryMountain(String countryMountain) {
        if (countryMountain == null || countryMountain.trim().length() < 4)
            throw new IllegalArgumentException("страна не должа иметь имя не короче 4 символов");
        this.countryMountain = countryMountain;
    }

    public int getHeightMountain() {
        return heightMountain;
    }

    public void setHeightMountain(int heightMountain) {
        if (heightMountain < 100)
            throw new IllegalArgumentException("гора высотой менее 100м не гора");
        this.heightMountain = heightMountain;
    }



}
