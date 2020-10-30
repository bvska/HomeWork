package com.howo.jjd.LvsA;

import java.util.*;

public class TimeLvsA {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 3000000; i++) {
            list.add(new Integer(i));
            list1.add(new Integer(i));
        }

        System.out.println("Добавление середина списка");
        long start=System.currentTimeMillis();
        for(int i=0;i<100;i++){
            list.add((list.size() / 2), 1);
        }
        System.out.println("LinkedList  = " + (System.currentTimeMillis()-start));

         start=System.currentTimeMillis();
        for(int i=0;i<100;i++){
            list1.add((list1.size() / 2), 1);
        }
        System.out.println("ArrayList = " + (System.currentTimeMillis()-start));


        System.out.println("Добавление начало");
        for(int i=0;i<100;i++){
            list.addFirst(1);
        }
        System.out.println("LinkedList  = " + (System.currentTimeMillis()-start));

        for(int i=0;i<100;i++){
            list1.add(0, 1);
        }
        System.out.println("ArrayList = " + (System.currentTimeMillis()-start));

        System.out.println("Добавление конец");
        for(int i=0;i<100;i++){
            list.addLast(1);
        }
        System.out.println("LinkedList  = " + (System.currentTimeMillis()-start));

        for(int i=0;i<100;i++){
            list1.add( 1);
        }
        System.out.println("ArrayList = " + (System.currentTimeMillis()-start));

        System.out.println("Получение из середины списка");
        for(int i=0;i<100;i++){
            list.get((list.size() / 2));
        }
        System.out.println("LinkedList  = " + (System.currentTimeMillis()-start));

        start=System.currentTimeMillis();
        for(int i=0;i<100;i++){
            list1.get((list1.size() / 2));
        }
        System.out.println("ArrayList = " + (System.currentTimeMillis()-start));


        System.out.println("Получение  начало");
        for(int i=0;i<100;i++){
            list.getFirst();
        }
        System.out.println("LinkedList  = " + (System.currentTimeMillis()-start));

        for(int i=0;i<100;i++){
            list1.get(0);
        }
        System.out.println("ArrayList = " + (System.currentTimeMillis()-start));

        System.out.println("Получение конец");
        for(int i=0;i<100;i++){
            list.getLast();
        }
        System.out.println("LinkedList  = " + (System.currentTimeMillis()-start));

        for(int i=0;i<100;i++){
            list1.get((list1.size()-1));
        }
        System.out.println("ArrayList = " + (System.currentTimeMillis()-start));


        System.out.println("Удаление из середины списка");
        for(int i=0;i<100;i++){
            list.remove((list.size() / 2));
        }
        System.out.println("LinkedList  = " + (System.currentTimeMillis()-start));

        start=System.currentTimeMillis();
        for(int i=0;i<100;i++){
            list1.remove((list1.size() / 2));
        }
        System.out.println("ArrayList = " + (System.currentTimeMillis()-start));


        System.out.println("Удаление  начало");
        for(int i=0;i<100;i++){
            list.removeFirst();
        }
        System.out.println("LinkedList  = " + (System.currentTimeMillis()-start));

        for(int i=0;i<100;i++){
            list1.remove(0);
        }
        System.out.println("ArrayList = " + (System.currentTimeMillis()-start));

        System.out.println("Удаление конец");
        for(int i=0;i<100;i++){
            list.removeLast();
        }
        System.out.println("LinkedList  = " + (System.currentTimeMillis()-start));

        for(int i=0;i<100;i++){
            list1.remove((list1.size()-1));
        }
        System.out.println("ArrayList = " + (System.currentTimeMillis()-start));

    }
}
