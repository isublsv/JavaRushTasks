package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <Key, Value extends Convertable<Key>> Map<Key, Value> convert(List<Value> list) {
        Map<Key, Value> result = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            result.put(list.get(i).getKey(), list.get(i));
        }
        return result;
    }
}
