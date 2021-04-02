package com.epam.jwd;

import java.util.Scanner;

import com.epam.jwd.bean.Point;

public class UserInput {

	public static Point enterPoint(String message) {

		int x, y;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		System.out.println(message);

		System.out.println("Введите x:");
		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("Введите x:");
		}
		x = sc.nextInt();

		sc.nextLine();
		System.out.println("Введите y:");
		while (!sc.hasNextInt()) {
			sc.nextLine();
			System.out.println("Введите y:");
		}
		y = sc.nextInt();

		return new Point(x, y);

	}

}
