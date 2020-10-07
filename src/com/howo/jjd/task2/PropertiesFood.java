package com.howo.jjd.task2;

public class PropertiesFood {
    private String nameFood;
    private int protein;
    private int fats;
    private int cd;
    private int calories;




    public PropertiesFood(String nameFood, int protein, int fats, int cd, int calories) {
        this.nameFood = nameFood;
        setProtein(protein);
        this.fats = fats;
        this.cd = cd;
        this.calories = calories;
    }

    public PropertiesFood(String nameFood, int fats, int cd, int calories) {
        setNameFood(nameFood);
        setFats(fats);
        setCd(cd);
        setCalories(calories);

    }

    public PropertiesFood(String nameFood, int calories) {
        setNameFood(nameFood);
        setCalories(calories);
    }

    public PropertiesFood(String nameFood, int protein, int cd){
        setNameFood(nameFood);
        setProtein(protein);
        setCd(cd);

    }






    public String getNameFood() {
        return nameFood;
    }

    public void setNameFood(String nameFood) {
        if (nameFood == null || nameFood.trim().length() < 3)
            throw new IllegalArgumentException("еда из 2х букв это ЯД");
        this.nameFood = nameFood;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        if (protein < 10) { throw new IllegalArgumentException("не сытно"); }
        this.protein = protein;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        if (fats < 10) throw new IllegalArgumentException("жира хоть немного должно быть");
        this.fats = fats;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        if (cd < 10) throw new IllegalArgumentException("не подходит");
        this.cd = cd;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        if (calories < 10) throw new IllegalArgumentException("Слишком мало калорий");
        this.calories = calories;
    }


    @Override
    public String toString() {
        return "PropertiesFood{" +
                "nameFood='" + nameFood + '\'' +
                ", protein=" + protein +
                ", fats=" + fats +
                ", cd=" + cd +
                ", calories=" + calories +
                '}';
    }


}
