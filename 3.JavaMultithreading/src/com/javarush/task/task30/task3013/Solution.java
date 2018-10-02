package com.javarush.task.task30.task3013;

/* 
Набираем код
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);

        String result1 = Integer.toString(solution.resetLowerBits(1), 2);
        System.out.println(result1);

        String result2 = Integer.toString(solution.resetLowerBits(4), 2);
        System.out.println(result2);

        String result3 = Integer.toString(solution.resetLowerBits(255), 2);
        System.out.println(result3);
    }

    public int resetLowerBits(int number) {
        //напишите тут ваш код
        number &= ~(number >> 1);
        number &= ~(number >> 2);
        number &= ~(number >> 4);
        number &= ~(number >> 8);
        number &= ~(number >> 16);
        return number;
    }
}