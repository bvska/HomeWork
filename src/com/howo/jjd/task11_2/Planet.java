package com.howo.jjd.task11_2;

public enum Planet {
    EARTH(60, 640, 1000 ), VENUS(55, 600, 900),
    MARS(58, 580, 700), JUPITER(70, 800, 1200);

    private int weight, radius, orbitRadius;

    Planet(int weight, int raius, int orbitRadius) {
        if (weight < 10) throw new IllegalArgumentException("масса < 10");
        if (raius < 30) throw new IllegalArgumentException("радиус < 30");
        if (orbitRadius < 500) throw new IllegalArgumentException("радиус орбиты мал");
      this.weight = weight;
      this.radius = raius;
      this.orbitRadius = orbitRadius;
    }

    public int getWeight() {
        return weight;
    }

    public int getRadius() {
        return radius;
    }

    public int getOrbitRadius() {
        return orbitRadius;
    }
}
