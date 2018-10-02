package com.javarush.task.task04.task0409;

/* 
Ближайшее к 10
*/

public class Solution {
    public static void main(String[] args) {
        closeToTen(8, 11);
        closeToTen(14, 7);
    }

    public static void closeToTen(int a, int b) {
        //::CODE:
        int dif1 = abs(a - 10);
        int dif2 = abs(b - 10);
        if (dif1 < dif2) System.out.println(a);
        else if (dif2 < dif1) System.out.println(b);
        else System.out.println(a);
    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}