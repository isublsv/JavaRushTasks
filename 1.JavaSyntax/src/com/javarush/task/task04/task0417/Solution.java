package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        checkPair(a, b, c);
    }

    public static void checkPair(int a, int b, int c) {
        if (a == b && a == c) System.out.println(a + " " + b + " " + c);
        else if (a == b) System.out.println(a + " " + b);
        else if (a == c) System.out.println(a + " " + c);
        else if (b == c) System.out.println(b + " " + c);
    }
}