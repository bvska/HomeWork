package com.howo.jjd.dicontainer;



import com.howo.jjd.dicontainer.fortest.config.CatConfig;
import com.howo.jjd.dicontainer.fortest.config.MouseConfig;
import com.howo.jjd.dicontainer.fortest.config.OwnerConfig;
import com.howo.jjd.dicontainer.marks.DIContainer;



import java.util.*;

public class Application {
    public static void main(String[] args) {
        Set<Class> classes = new HashSet<>();
        classes.add(Cat.class);
        classes.add(Mouse.class);
        classes.add(Owner.class);
        classes.add(CatConfig.class);
        classes.add(MouseConfig.class);
        classes.add(OwnerConfig.class);

        // TODO:: инициализация DI контейнера и тд

        DIContainer container = new DIContainer();
        Map<Class, Object> map = new HashMap<>();
        for (Class reclass : classes){
            try{
                map.put(reclass, container.getObject(reclass));
            } catch (Exception e){
                System.out.println("Что-то пошло не так");
                try {
                    throw new Exception(e.getCause());
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }

        Iterator<Map.Entry<Class, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getValue());
        }


    }
}