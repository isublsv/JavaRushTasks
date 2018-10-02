package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        StringBuilder sb = new StringBuilder();
        for (Dish d : Dish.values()) {
            sb.append(d.toString()).append(", ");
        }
        return sb.toString().substring(0, sb.length() - 2);
    }
}

