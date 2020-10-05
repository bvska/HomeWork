package wlesson5;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int N = 10; // длина массива
        System.out.println("Вводите слова, exit выход");
        String[] words = new String[N];
        outer: for (int i = 0; i < words.length; i = i) {
            String s = read.nextLine();
            if (s.equals("exit"))
                break;
            else {
                 for (int j = 0; j < words.length; j++) {
                     if (s.equals("exit"))
                         break;
                    if (s.equals(words[j])) {
                        System.out.println("повтор");
                        j = 0;
                        continue outer;
                    }
                    break;
                }
                words[i] = s;
                i++;
            }
        }
        System.out.println(Arrays.toString(words));
    }
}
