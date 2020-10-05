package wlesson5;

import javax.sound.midi.Soundbank;

public class Task3 {
    public static void main(String[] args) {
        //String s = "202";
        String s = "а роза упала на лапу Азора";
        s = s.toLowerCase().replaceAll(" ", "");
        StringBuffer read = new StringBuffer(s);
        String m = (read.reverse()).toString();
        if (m.compareTo(s) == 0){
            System.out.println("полиндром");}
        else
            System.out.println(" не полиндром");


    }
}
