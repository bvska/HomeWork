package com.howo.jjd.dicontainer.marks;



import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class DIContainer {

    public <T> T getObject(Class reclass) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        T object;
        if (reclass.isAnnotationPresent(RequiredClass.class)) {
            object = (T)reclass.getConstructor().newInstance();
            Field[] fields = object.getClass().getDeclaredFields();
            boolean hasConfig = false;
            for (Field field : fields) {
                if (field.isAnnotationPresent(RequiredField.class)) {
                    setField(object, field);
                }
                if (field.getType().isAnnotationPresent(ConfigClass.class)) hasConfig = true;
            }
            if (hasConfig){
                for (Field field : fields) {
                    try {
                        object.getClass().getMethod(getSetterName(field)).invoke(object);
                    }
                    catch (NoSuchMethodException ignored){
                    }
                }
            }

        } else if (reclass.isAnnotationPresent(ConfigClass.class)) {
            object = (T)reclass.getConstructor().newInstance();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                setField(object, field);
            }
        } else {
            object = (T)reclass.getConstructor().newInstance();
        }
        return object;
    }


    private void setField (Object object, Field field) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        field.setAccessible(true);
        if (field.getType().isAnnotationPresent(ConfigClass.class) || field.getType().isAnnotationPresent(RequiredClass.class)){
            field.set(object, getObject(field.getType()));
        } else {
            Object param;
            try {
                param = getParam(object, field);
                object.getClass().getMethod(getSetterName(field), field.getType()).invoke(object, param);
            } catch (NullPointerException ignored){

            }
        }
    }

    private String getSetterName(Field field) {
        return "set" + (field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
    }

    private Object getParam (Object object, Field field) {
        String filename = object.getClass().getDeclaredAnnotation(ConfigClass.class).file();
        Properties properties = new Properties();
        try (InputStream input = DIContainer.class.getClassLoader().getResourceAsStream(filename)){
            properties.load(input);
        } catch (IOException ioException){
            ioException.printStackTrace();
        }

        String key = object.getClass().getDeclaredAnnotation(ConfigClass.class).prefix() +
                "." +
                field.getName().substring(object.getClass().getDeclaredAnnotation(ConfigClass.class).prefix().length()).toLowerCase();


        if (field.getType().isAssignableFrom(int.class) || field.getType().isAssignableFrom(Integer.class)){
            return Integer.parseInt((String) properties.get(key));
        }
        if (field.getType().isAssignableFrom(short.class) || field.getType().isAssignableFrom(Short.class)){
            return Short.parseShort((String) properties.get(key));
        }
        if (field.getType().isAssignableFrom(byte.class) || field.getType().isAssignableFrom(Byte.class)){
            return Byte.parseByte((String) properties.get(key));
        }
        if (field.getType().isAssignableFrom(long.class) || field.getType().isAssignableFrom(Long.class)){
            return Long.parseLong((String) properties.get(key));
        }
        if (field.getType().isAssignableFrom(float.class) || field.getType().isAssignableFrom(Float.class)){
            return Float.parseFloat((String) properties.get(key));
        }
        if (field.getType().isAssignableFrom(double.class) || field.getType().isAssignableFrom(Double.class)){
            return Double.parseDouble((String) properties.get(key));
        }
        if (field.getType().isAssignableFrom(boolean.class) || field.getType().isAssignableFrom(Boolean.class)){
            return Boolean.parseBoolean((String) properties.get(key));
        }
        if (field.getType().isAssignableFrom(char.class) || field.getType().isAssignableFrom(Character.class)){
            return  properties.get(key);
        }
        if (field.getType().isAssignableFrom(String.class)){
            return properties.get(key);
        }
        return null;
    }
}

