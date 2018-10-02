package com.javarush.task.task29.task2908;

public class Cicle implements Computable<Integer, Double> {
    @Override
    public Double compute(Integer integer) throws InterruptedException {
        return 2 * Math.PI * integer;
    }
}
