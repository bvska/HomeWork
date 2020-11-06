package com.howo.jjd.reflect;



import com.ifmo.jjd.lesson13.types.User;
import com.ifmo.jjd.lesson17.TextMessage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class  UseUserM {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {

        UserM user2;
        UserM user1 = new UserM("Petr", 40);
        System.out.println(toString(user1));

        Class cl = Class.forName(UserM.class.getName());
        user2 = (UserM) cl.newInstance();
        System.out.println(toString(user2));

    }
    public static String toString(Object o) throws IllegalAccessException {
        Class u = o.getClass();
        Field[] fields = u.getDeclaredFields();
        String info = "";
        for (Field field : fields) {
            info = info + " " + field.getName() + ": " + field.get(o).toString() + "\n";


        }
        return info;
    }
}
