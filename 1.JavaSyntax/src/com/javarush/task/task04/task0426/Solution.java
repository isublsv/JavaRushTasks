package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);

        int number = 0;
        if (scanner.hasNextInt())
            number = scanner.nextInt();

        if (number < 0 && number % 2 == 0) System.out.println("отрицательное четное число");
        else if (number < 0 && number % 2 != 0) System.out.println("отрицательное нечетное число");
        else if (number > 0 && number % 2 == 0) System.out.println("положительное четное число");
        else if (number > 0 && number % 2 != 0) System.out.println("положительное нечетное число");
        else if (number == 0) System.out.println("ноль");
    }
}
