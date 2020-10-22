package com.howo.jjd.task12_1;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class Excep {


    public static void startM()  {
        Status tp;
        for (Status o : Status.values()) {
            tp = o;
            Excep.throwException(tp);
        }
    }

    static void throwException(Status status){
        try {
            if (status == Status.FILE_NOT_FOUND ) throw new FileNotFoundException("производим ошибки");
            else if (status == Status.ACCESS_DENIED) throw new AccessDeniedException("а у нас тут ошибочка вышла");
            else  {throw new JarException();}

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("привет");

        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
            System.out.println("ого как неожиданно");
            try {
                throw new AccessDeniedException("мы любим ошибки").initCause(e);
            }catch (Throwable e1) {
                e1.printStackTrace();
            }
        } catch (JarException e1) {
            e1.printStackTrace();
        }
    }
}
