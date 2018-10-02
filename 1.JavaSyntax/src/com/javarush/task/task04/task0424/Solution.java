package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        checkNumber(a, b, c);
    }

    public static void checkNumber(int a, int b, int c) {
        if (a == b & a != c) System.out.println(3);
        else if (a == c && a != b) System.out.println(2);
        else if (b == c && a != b) System.out.println(1);
    }
}
