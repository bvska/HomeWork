package com.howo.jjd.task11_2;

public class Demo {
    public static void main(String[] args) {
        Planet[] planets = Planet.values();
        for (Planet planet : planets) {
            System.out.println("Планета: " + planet + " - Вес: " + planet.getWeight() + " Радиус: " +
                    planet.getRadius() + " Радиус орбиты: " + planet.getOrbitRadius());

        }
    }
}
