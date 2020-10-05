package wlesson5;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        String s = "в предложении все абракадабрааа слова разной длины";
        String[] mas = s.split(" ");
        String s1 = mas[0];
        int[] k = new int[mas.length];
        int i = 0, max;
        for (int j = 0; j < mas.length; j++) {
            k[j] = mas[j].toCharArray().length;
        }
        max = k[0];
        for (int j = 0; j < k.length; j++) {
            if (max < k[j]){
                max = k[j];
                s1 = mas[j];}
        }
        System.out.println("самое длинное слово: " + s1);




            

    }

}
