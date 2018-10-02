package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Иванов", 100);
        map.put("Сидоров", 200);
        map.put("Коновалов", 300);
        map.put("Котелков", 100);
        map.put("Игнатович", 400);
        map.put("Крюков", 500);
        map.put("Обоев", 600);
        map.put("Теркин", 400);
        map.put("Иванович", 700);
        map.put("Забоев", 800);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            if (iterator.next().getValue() < 500) iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}