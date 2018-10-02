package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] m = new int[3];

        for (int i = 0; i < m.length; i++) {
            m[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int counterPos = 0;
        int counterNeg = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i] > 0) counterPos++;
            else if (m[i] < 0) counterNeg++;
        }

        System.out.println("количество отрицательных чисел: " + counterNeg);
        System.out.println("количество положительных чисел: " + counterPos);

    }
}
