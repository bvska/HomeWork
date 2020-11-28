package com.howo.jjd.threadMulti;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

public class Waiter implements Runnable{
    private ArrayBlockingQueue<Zakaz> zakazs1;
    private ArrayBlockingQueue<Zakaz> zakazs2;

    public Waiter(ArrayBlockingQueue<Zakaz> zakazs1,ArrayBlockingQueue<Zakaz> zakazs2) {
        this.zakazs1 = Objects.requireNonNull(zakazs1);
        this.zakazs2 = Objects.requireNonNull(zakazs2);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            try {
                Zakaz zakaz = zakazs1.take();
                System.out.println("относим на кухню: " + zakaz.getN() + " ");
                Thread.sleep(1000);
                if (zakaz != null)
                zakazs2.put(zakaz);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
}
