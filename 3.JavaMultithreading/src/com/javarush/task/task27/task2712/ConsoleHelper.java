package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(Dish.allDishesToString());
        List<Dish> dishList = new ArrayList<>();
        writeMessage("Введите название блюда:");
        String s = readString().toLowerCase();
        while (!s.equalsIgnoreCase("exit")) {
            if (Dish.allDishesToString().toLowerCase().contains(s)) {
                String value = s.substring(0, 1).toUpperCase() +
                        s.substring(1).toLowerCase();
                dishList.add(Dish.valueOf(value));
            } else {
                writeMessage("Такого блюда нет.");
            }
            s = readString().toLowerCase();
        }
        return dishList;
    }
}
