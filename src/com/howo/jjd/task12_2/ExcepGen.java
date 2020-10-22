package com.howo.jjd.task12_2;

import org.w3c.dom.ls.LSOutput;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

public class ExcepGen {
    private static Throwable[] excepGens = new Throwable[9];
    public static void genException() throws EnumConstantNotPresentException {

        try {
            int a = 10;
            int b = 0;
            int res = a / b;
        } catch (ArithmeticException e){
            excepGens[0] = e;
        }
        try{
            int[] j = new int[2];
            j[5] = 7;
        } catch (ArrayIndexOutOfBoundsException e){
            excepGens[1] = e;
        }
        try {
            Object o = new java.util.Date();
            Integer i = (Integer)o;
        } catch (ClassCastException e){
            excepGens[2] = e;
        }
        try {
            int i = 10;
            if (i < 10) throw new IllegalArgumentException("i < 10");
        } catch (IllegalArgumentException e){
            excepGens[3] = e;
        }
        try {
            // попытка ввести в массив элемент несовместимого типа
            throw new ArrayStoreException("");
        }catch (ArrayStoreException e){
            excepGens[4] = e;}
        try{
            // Попытка использования нумерованного значение которое не было определено  ранее
            //throw new EnumConstantNotPresentException();
        }catch (EnumConstantNotPresentException e){
            excepGens[5] = e;
        }
        try {
            //недопустимая операция контроля, пример ожидание разблокировки потока
            throw new IllegalMonitorStateException();
        } catch (IllegalMonitorStateException e){
            excepGens[6] = e;
        }
        try {
            // Недопутимое состояние среды выполнения или приложения
            throw new IllegalStateException();
        } catch (IllegalStateException e){
            excepGens[7] = e;
        }
        try {
            String s = "OLOLO";
            String m = null;
            if (m.equals(s)) {
            }}
         catch (NullPointerException e){
                excepGens[8] = e;
            }
        try {
            int[] i = new int[-6];
            }catch (NegativeArraySizeException e){
            excepGens[8] = e;
        }
        ExcepGen.getInfo();
    }

    static public void getInfo(){
        for (int i = 0; i < excepGens.length; i++) {
            if (!Objects.isNull(excepGens[i]))
            System.out.println((i + 1) + ": " + excepGens[i]);

        }
    }
}
