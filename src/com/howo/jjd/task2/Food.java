package com.howo.jjd.task2;

public class Food {
    public static void main(String[] args) {
        PropertiesFood fruit = new PropertiesFood("apple", 12,23, 65 ,56);
        PropertiesFood meat = new PropertiesFood("Свинина", 98, 80, 34, 56);
        PropertiesFood fish = new PropertiesFood("Лосось",56, 34, 67);
        PropertiesFood vegetable = new PropertiesFood("Картошка", 29, 65, 45, 56);

       // System.out.println(fruit);


          MyFood basket = new MyFood(12);

          basket.addBasket(fruit, meat, fish, vegetable, fruit);

         // System.out.println(fruit.getNameFood());
        System.out.println(basket.getBasketInfo());


    }
}
