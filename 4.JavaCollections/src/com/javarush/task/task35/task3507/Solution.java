package com.javarush.task.task35.task3507;

import java.io.File;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        File folder = new File(pathToAnimals);
        for (File file : folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".class"))){
            file.toPath().getClass();
        }
        return null;
    }

}

