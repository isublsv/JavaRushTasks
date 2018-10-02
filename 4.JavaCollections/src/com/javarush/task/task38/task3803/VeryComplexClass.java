package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/
import java.util.Date;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object o = new Date();
        Integer i = (Integer) o;

    }

    public void methodThrowsNullPointerException() {
        String s = null;
        s.charAt(1);
    }

    public static void main(String[] args) {
        VeryComplexClass veryComplexClass = new VeryComplexClass();
        veryComplexClass.methodThrowsClassCastException();
        veryComplexClass.methodThrowsNullPointerException();
    }
}
