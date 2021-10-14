package org.example;

import org.example.annotations.CustomClassName;
import org.example.annotations.DefaultValue;
import org.example.annotations.Init;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Application {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        System.out.println(MyClass.class.isAnnotationPresent(CustomClassName.class));

        System.out.println(

                MyClass.class.getAnnotation(CustomClassName.class)
                        .name()

        );

        MyClass obj = new MyClass();
        Method[] methods = MyClass.class.getDeclaredMethods();
        for (Method method :
                methods) {

            if(method.isAnnotationPresent(Init.class)){
                Object[] parameters = getMethodParams(method);
                method.invoke(obj, parameters);
            }

        }
    }

    private static Object[] getMethodParams(Method method) {

        Parameter[] params =  method.getParameters();
       Object[] result = new Object[params.length];
        for (int i =0; i<params.length;i++){
            Parameter p = params[i];
            if(p.isAnnotationPresent(DefaultValue.class)){
                if(p.getType().equals(String.class)){
                    result[i] = p.getAnnotation(DefaultValue.class).myValue();
                }
            }

        }
        return result;
    }
}
