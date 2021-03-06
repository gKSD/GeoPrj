package server.resourceSystem;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: Антон
 * Date: 30.11.13
 * Time: 11:15
 * To change this template use File | Settings | File Templates.
 */
public class ReflectionHelper {
    public static Object createIntance(String className){
        try {
            return Class.forName(className).newInstance();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setFieldValue(Object object,
                                     String fieldName,
                                     String value){

        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);

            if(field.getType().equals(String.class)){
                field.set(object, value);
            } else if (field.getType().equals(int.class)){
                field.set(object, Integer.decode(value));
            }

            field.setAccessible(false);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}