package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double t = Double.parseDouble(br.readLine());
        check(t);
/*      check(2.5);
        check(3);
        check(4);
        check(5);*/
    }

    public static void check(double t) {
        double dif = t % 5;
        if (t < 60){
            if (dif >= 0 && dif < 3) System.out.println("зелёный");
            else if (dif >=3 && dif < 4) System.out.println("желтый");
            else if (dif >=4 && dif < 5) System.out.println("красный");
        }
    }
}