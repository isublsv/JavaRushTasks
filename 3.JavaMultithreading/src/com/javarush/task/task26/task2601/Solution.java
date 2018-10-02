package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {

        Integer[] ints = {5, 3, 1, 6};

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int m = 0;
        if (array.length % 2 == 0) m = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
        else m = array[array.length/2];

        int finalM = m;
        Comparator<Integer> comparator = (o1, o2) -> {
            int n1 = Math.abs(finalM - o1);
            int n2 = Math.abs(finalM - o2);
            if (n1 > n2) return 1;
            else if (n1 < n2) return -1;
            else return 0;
        };

        Arrays.sort(array,comparator);
        return array;
    }
}
