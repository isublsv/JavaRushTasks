package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		TreeSet<Character> chars = new TreeSet<>(Comparator.naturalOrder());
		while (br.ready()) {
			String s = br.readLine();
			char[] charArray = s.replaceAll("\\W", "").
					toLowerCase().toCharArray();
			for (char c : charArray) {
				chars.add(c);
			}
		}

		if (chars.size() <= 5) {
			chars.forEach(System.out::print);
		} else chars.stream().limit(5).forEach(System.out::print);
	}
}
