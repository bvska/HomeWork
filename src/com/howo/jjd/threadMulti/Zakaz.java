package com.howo.jjd.threadMulti;

public class Zakaz {
    private int n;
    private static int count = 1;

    public Zakaz(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public  void setN(int n) {
        this.n = n;
    }

    public static Zakaz getZakaz(){
        return new Zakaz(count++);
    }

    @Override
    public String toString() {
        return "Zakaz{" +
                "Номер заказа: " + n +
                '}';
    }
}
