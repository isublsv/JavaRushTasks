package com.javarush.task.task27.task2712;

import java.util.Observable;
import java.util.Observer;

public class Cook implements Observer {
    private String name;
    public Cook(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
    @Override
    public void update(Observable o, Object arg) {
        ConsoleHelper.writeMessage("Start cooking - " + arg);
    }
}
