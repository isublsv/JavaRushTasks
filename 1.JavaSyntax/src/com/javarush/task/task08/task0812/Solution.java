package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        ArrayList<Integer> list = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            list.add(Integer.valueOf(bufferedReader.readLine()));
        }

        int count = 1;
        int max = 1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (Objects.equals(list.get(i), list.get(i + 1))) {
                count++;
                if (max < count)
                    max = count;
            } else
                count = 1;
        }
        System.out.println(max);
    }
}