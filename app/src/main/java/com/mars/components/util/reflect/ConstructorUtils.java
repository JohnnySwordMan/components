package com.mars.components.util.reflect;

import java.lang.reflect.Constructor;

/**
 * Created by geyan on 2021/1/16
 */
public class ConstructorUtils {
    
    public static Object newInstance(String className) {
        try {
            Class<?> cls = Class.forName(className);
            return newInstance(cls, new Class[]{}, new Object[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object newInstance(Class<?> cls) {
        return newInstance(cls, new Class[]{}, new Object[]{});
    }


    public static Object newInstance(String className, Class<?>[] parameterTypes, Object[] parameterValues) {
        try {
            Class<?> cls = Class.forName(className);
            return newInstance(cls, parameterTypes, parameterValues);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object newInstance(Class<?> cls, Class<?>[] parameterTypes, Object[] parameterValues) {
        try {
            Constructor<?> constructor = cls.getDeclaredConstructor(parameterTypes);
            constructor.setAccessible(true);
            return constructor.newInstance(parameterValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
