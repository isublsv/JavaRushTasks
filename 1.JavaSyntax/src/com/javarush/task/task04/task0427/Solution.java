package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(bufferedReader.readLine());

        if (number >= 1 && number <= 999) {
            if (number < 10 && number % 2 == 0) System.out.println("четное однозначное число");
            else if (number < 10 && number % 2 != 0) System.out.println("нечетное однозначное число");
            else if (number >= 10 && number < 100 && number % 2 == 0) System.out.println("четное двузначное число");
            else if (number >= 10 && number < 100 && number % 2 != 0) System.out.println("нечетное двузначное число");
            else if (number >= 100 && number % 2 == 0) System.out.println("четное трехзначное число");
            else if (number >= 100 && number % 2 != 0) System.out.println("нечетное трехзначное число");
        }
    }
}
