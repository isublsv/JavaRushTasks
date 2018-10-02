package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] m = new int[3];

        for (int i = 0; i < m.length; i++) {
            m[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int counter = 0;
        for (int i = 0; i < m.length; i++) {
            if (m[i] > 0) counter++;
        }

        System.out.println(counter);
    }
}
