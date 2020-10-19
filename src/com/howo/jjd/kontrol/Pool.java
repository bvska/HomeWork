package com.howo.jjd.kontrol;

import java.util.Arrays;

public class Pool implements AddDel{
    private final String name = "Бассейн";

    protected Abonement[] poolA = new Abonement[20];

    public String getName() {
        return name;
    }

    @Override
    public void addZal(Abonement ab) {
        for (int i = 0; i < poolA.length; i++) {
            if (poolA[i] == null){
                poolA[i] = ab;
                System.out.println(Logger.clientInfo(ab, name));
                return;}
            if (poolA[poolA.length- 1 ] != null){
                System.out.println("мест нет");
            return;}
        }
    }


    @Override
    public void delZal() {
        for (int i = 0; i < poolA.length; i++) {
            poolA[i] = null;
        }
    }

    @Override
    public void delTimeZal() {

    }

    @Override
    public String toString() {

        return "Pool{" +
                "poolA=" + Arrays.toString(poolA) +
                '}';
    }
    public Boolean test(Abonement ab){
        for (int i = 0; i < poolA.length; i++) {
            if (poolA[i] == ab)
                return true;
        }
        return  false;
    }

    public Abonement[] getPoolA() {
        return poolA;
    }

}


