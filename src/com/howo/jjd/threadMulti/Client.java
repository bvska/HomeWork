package com.howo.jjd.threadMulti;


import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class Client implements Runnable{

    private Zakaz zakaz;
    private ArrayBlockingQueue<Zakaz> zakazs1;
    private ArrayBlockingQueue<Zakaz> zakazs3;



    public Client(ArrayBlockingQueue<Zakaz> zakazs1, ArrayBlockingQueue<Zakaz> zakazs3) {
       this.zakazs1 = Objects.requireNonNull(zakazs1);
        this.zakazs3 = Objects.requireNonNull(zakazs3);

    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            System.out.println("Делаем заказ: "  + Thread.currentThread());
            Zakaz zakaz = Zakaz.getZakaz();
            try {
                zakazs1.put(zakaz);
                Thread.sleep(10000);
                System.out.println("забираем заказ: " + zakaz.getN() + " " + zakazs3.take());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
