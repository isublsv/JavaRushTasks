package com.javarush.task.task06.task0606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        while (number != 0) {
            int current = number % 10;
            if (current % 2 == 0) even++;
            else if (current % 2 != 0) odd++;
            number = (number - current) / 10;
        }

        System.out.println("Even: " + even + " Odd: " + odd);
    }
}
