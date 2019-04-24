package com.javarush.task.task39.task3908;

import java.util.Set;
import java.util.stream.Collectors;

/*
Возможен ли палиндром?
*/
public class Solution {
	public static void main(String[] args) {

	}

	public static boolean isPalindromePermutation(String s) {
		if (s.length() <= 1) return true;

		Set<Character> charSet = s.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

		s = s.toLowerCase();
		int limit = 0;//счетчик показывает количество уникальных букв, которые повторяются нечетное количество раз, если результат > 1 => false
		for (Character c : charSet) {
			int charCounter = s.length() - s.replaceAll(c.toString(), "").length();
			if (charCounter % 2 != 0) {
				limit++;
				if (limit > 1) return false;
			}
		}

		return true;
	}
}
