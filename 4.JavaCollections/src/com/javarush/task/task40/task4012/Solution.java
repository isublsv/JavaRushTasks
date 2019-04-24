package com.javarush.task.task40.task4012;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
*/

public class Solution {
	public static void main(String[] args) {
		LocalDate start = LocalDate.of(2017, 11, 1);
		LocalDate end = LocalDate.now();
		LocalTime time = LocalTime.of(12, 50);

		LocalDateTime test = LocalDateTime.of(start, time);

		System.out.println("isLeap: " + isLeap(start));
		System.out.println("isBefore should be true: " + isBefore(test));
		System.out.println(addTime(time, 6, ChronoUnit.HOURS));
		System.out.println(getPeriodBetween(start, end));
	}

	public static boolean isLeap(LocalDate date) {
		return date.isLeapYear();
	}

	public static boolean isBefore(LocalDateTime dateTime) {
		return dateTime.isBefore(LocalDateTime.now());
	}

	public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) {
		return LocalTime.from(time).plus(n, chronoUnit);
	}

	public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) {
		if (firstDate.compareTo(secondDate) <= 0) return Period.between(firstDate, secondDate);
		else return Period.between(secondDate, firstDate);
	}
}
