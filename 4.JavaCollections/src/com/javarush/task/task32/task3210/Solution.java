package com.javarush.task.task32.task3210;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {

        String fileName = args[0];
        Integer number = Integer.parseInt(args[1]);
        String text = args[2];

        RandomAccessFile r = new RandomAccessFile(fileName, "rw");
        r.seek(number);

        byte[] buff = new byte[text.length()];
        r.read(buff, 0, text.length());

        r.seek(r.length());

        if (Arrays.equals(buff, text.getBytes())) {
            r.write("true".getBytes());
        } else r.write("false".getBytes());

        r.close();
    }

    void convertByteToString(byte readBytes[]){

    }
}
