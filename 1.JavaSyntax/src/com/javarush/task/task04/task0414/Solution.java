package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int year = Integer.parseInt(br.readLine());
        check(year);
/*        check(1984);    //вис
        check(1983);    //невис
        check(1700);    //невис
        check(1600);    //вис
        check(2100);    //невис*/
    }

    public static void check(int year) {

        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 == 0) System.out.println("количество дней в году: 366");
            else if (year % 100 != 0 && year % 400 != 0) System.out.println("количество дней в году: 366");
            else if (year % 100 != 0 || year % 400 != 0) System.out.println("количество дней в году: 365");
        } else System.out.println("количество дней в году: 365");
    }
}