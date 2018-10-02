package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] m = new int[15];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < m.length; i++) {
            m[i] = Integer.parseInt(br.readLine());
            if (i % 2 == 0 || i == 0) sumEven +=m[i];
            else if (i % 2 != 0) sumOdd += m[i];
        }

        if ( sumEven > sumOdd) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
