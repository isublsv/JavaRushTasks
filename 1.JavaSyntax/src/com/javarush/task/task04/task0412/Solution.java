package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        method(number);
    }

    public static void method(int num) {
        if (num > 0) System.out.println(num * 2);
        else if (num < 0) System.out.println(num + 1);
        else if (num == 0) System.out.println(num);
    }
}
