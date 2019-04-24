package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/

public class Solution {
	public static void main(String[] args) {
		Color[][] colors = {{Color.RED, Color.GREEN, Color.BLUE},
				{Color.INDIGO, Color.ORANGE, Color.VIOLET},
				{Color.YELLOW, Color.RED, Color.INDIGO}};

		PhotoPaint paint = new PhotoPaint();
		System.out.println(paint.paintFill(colors, 1, 2, Color.YELLOW));
		System.out.println(paint.paintFill(colors, 0, 0, Color.INDIGO));
		System.out.println(paint.paintFill(colors, 1, 2, Color.RED));
		System.out.println(paint.paintFill(colors, 4, 2, Color.RED));

		for (int i = 0; i < colors.length; i++) {
			for (int j = 0; j < colors[i].length; j++) {
				System.out.print(colors[i][j] + " ");
			}
			System.out.println();
		}
	}
}
