package com.howo.jjd.threadMulti;



import java.util.concurrent.ArrayBlockingQueue;

public class App {
    public static void main(String[] args) {

        ArrayBlockingQueue<Zakaz> zakazs1 = new ArrayBlockingQueue<>(6, true);
        ArrayBlockingQueue<Zakaz> zakazs2 = new ArrayBlockingQueue<>(3, true);
        ArrayBlockingQueue<Zakaz> zakazs3 = new ArrayBlockingQueue<>(2, true);

        new Thread(new Client(zakazs1, zakazs3)).start();
        new Thread(new Client(zakazs1, zakazs3)).start();
        new Thread(new Client(zakazs1, zakazs3)).start();
        new Thread(new Client(zakazs1, zakazs3)).start();
        new Thread(new Client(zakazs1, zakazs3)).start();
        new Thread(new Client(zakazs1, zakazs3)).start();
        new Thread(new Waiter(zakazs1, zakazs2)).start();
        new Thread(new Waiter(zakazs1, zakazs2)).start();
        new Thread(new Waiter(zakazs1, zakazs2)).start();
        new Thread(new Povar(zakazs2, zakazs3)).start();
        new Thread(new Povar(zakazs2, zakazs3)).start();


    }
}
