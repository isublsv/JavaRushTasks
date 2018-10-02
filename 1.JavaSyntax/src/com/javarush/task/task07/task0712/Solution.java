package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            list.add(bufferedReader.readLine());
        }

        int indexMin = 0;
        int indexMax = 0;
        int max = list.get(0).length();
        int min = list.get(0).length();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > max) {
                max = list.get(i).length();
                indexMax = i;
            } else if (list.get(i).length() < min) {
                min = list.get(i).length();
                indexMin = i;
            }
        }
        if ( indexMax > indexMin) System.out.println(list.get(indexMin));
        else System.out.println(list.get(indexMax));

    }
}
