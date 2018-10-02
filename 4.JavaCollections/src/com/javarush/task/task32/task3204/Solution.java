package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        String laters = "abcdefghijklmnopqrstuvwxyz";
        String digits = "1234567890";
        StringBuffer passw = new StringBuffer();

        for (int i=0; i<4; i++) {
            passw.append(laters.charAt((int)(Math.random()*26)));
        }
        for (int i=0; i<2; i++) {
            passw.append(digits.charAt((int)(Math.random()*10)));
        }
        for (int i=0; i<2; i++) {
            passw.append(laters.toUpperCase().charAt((int)(Math.random()*26)));
        }

        try {
            output.write(passw.toString().getBytes());
        } catch (Exception e)
        {

        }

        return output;
/*        StringBuilder password = new StringBuilder();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String LOWER = "abcdefghijklmnopqrstuvwxyz";
        String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String DIGITS = "0123456789";
        String[] chars = new String[]{LOWER, UPPER, DIGITS};
        //String sum = LOWER + UPPER + DIGITS;

        Random r = new Random(System.nanoTime());

        for (int i = 0; i < 8; i++) {
            int set = r.nextInt(chars.length);
            int k = r.nextInt(chars[set].length() - 1);
            password.append(chars[set].charAt(k));
        }
        byteArrayOutputStream.write(password.toString().getBytes());
        return byteArrayOutputStream;*/
    }
}