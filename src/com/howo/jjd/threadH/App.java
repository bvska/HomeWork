package com.howo.jjd.threadH;

import java.util.ArrayList;


public class App {
    public static void main(String[] args) {

        ArrayList<Account> list = new ArrayList<>(10);

        for (int i = 1; i < 11; i++) {
            list.add(new Account(i, 7000));
        }

        Bank bank = new Bank();
        for (int i = 0; i < 30; i++) {
            int k = (int)(Math.random() * 9) + 1;
            int m = (int)(Math.random() * 9) + 1;
                if (k != m)
            bank.transferMoney(list.get(k), list.get(m), 300);
                else
                System.out.println("подозрительная операция!");
        }




    }
}
