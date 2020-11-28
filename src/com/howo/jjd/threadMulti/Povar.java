package com.howo.jjd.threadMulti;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class Povar implements Runnable{
    private ArrayBlockingQueue<Zakaz> zakazs2;
    private ArrayBlockingQueue<Zakaz> zakazs3;


    public Povar(ArrayBlockingQueue<Zakaz> zakazs2, ArrayBlockingQueue<Zakaz> zakazs3) {
        this.zakazs2 = Objects.requireNonNull(zakazs2);
        this.zakazs3 = Objects.requireNonNull(zakazs3);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){

            try {
                Zakaz zakaz = zakazs2.take();
                System.out.println("готовим: " + zakaz.getN() + " ");
                Thread.sleep(5000);
                zakazs3.put(zakaz);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
