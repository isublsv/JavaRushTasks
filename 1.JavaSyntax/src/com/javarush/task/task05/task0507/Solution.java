package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0, counter = 0;

        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == -1) break;
            sum += num;
            counter++;
        }
        double d = (double) sum/counter;
        System.out.println(d);
    }
}

