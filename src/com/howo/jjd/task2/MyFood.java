package com.howo.jjd.task2;



public class MyFood {

    private PropertiesFood[] myFoods;

    public MyFood(int count){
        if (count < 10)
            throw new IllegalArgumentException("count не должен быть менее 10");
        myFoods = new PropertiesFood[count];
    }



    public void addBasket(PropertiesFood... foods) {
         for (int i = 0, j = 0; j < foods.length && i < myFoods.length; j++) {
            if (foods[j].getProtein() > 30) {
                System.out.println(foods[j].getNameFood() + " много белок!");
                continue;
            } else {
                if (foods[j].getFats() > 70) {
                    System.out.println(foods[j].getNameFood() + " очень жирное");
                    continue;
                } else {
                    myFoods[i] = foods[j];

                    i++;
                }
            }


        }
    }
         public String getBasketInfo(){
            StringBuilder sb = new StringBuilder();
            for (PropertiesFood food : myFoods){
                if (food != null) sb.append(food.getNameFood()).append(" ").append(food.getCalories()).append("\n");

            }
            return sb.toString();
        }

 }
