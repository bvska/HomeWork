package com.howo.jjd.threadH;

public class Transaction implements Runnable{
    private Account src; // с какого аккаунта осуществлять перевод
    private Account dst; // на какой аккаунт осуществлять перевод
    private int money; // сколько переводить

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }


    @Override
    public void run() {
        // TODO перевод денежных средств со счета src на счет dst
        //  в количестве money

        if (src.getBalance() >= money){
            src.setBalance(src.getBalance() - money);
            dst.setBalance(dst.getBalance() + money);
            System.out.println("id: " + src.getId() + ": " + src.getBalance() + " "
                    + "id: " + dst.getId() + ": " + dst.getBalance());
        }
        else
            System.out.println("для осуществления транзакии не достаточно денежных средст");
    }
}
