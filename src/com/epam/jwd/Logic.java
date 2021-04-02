package com.epam.jwd;

import java.util.Random;
import com.epam.jwd.bean.Line;
import com.epam.jwd.bean.Point;
import com.epam.jwd.bean.Square;
import com.epam.jwd.bean.Triangle;

public class Logic {

	public void fillArray(Point... points) {

		Random random = new Random();

		for (int i = 0; i < points.length; i++) {
			points[i] = new Point(random.nextInt(20), random.nextInt(20));
		}

	}

	public void fillArray(Line... lines) {

		Random random = new Random();

		for (int i = 0; i < lines.length; i++) {
			lines[i] = new Line(new Point(random.nextInt(20), random.nextInt(20)),
					new Point(random.nextInt(20), random.nextInt(20)));
		}

	}

	public void fillArray(Triangle... triangles) {

		Random random = new Random();

		for (int i = 0; i < triangles.length; i++) {
			triangles[i] = new Triangle(new Point(random.nextInt(20), random.nextInt(20)),
					new Point(random.nextInt(20), random.nextInt(20)),
					new Point(random.nextInt(20), random.nextInt(20)));
		}

	}

	public void fillArray(Square... squares) {

		for (int i = 0; i < squares.length; i++) {
			squares[i] = new Square(UserInput.enterPoint("Введите координаты 1 точки квадрата:"),
					UserInput.enterPoint("Введите координаты 2 точки квадрата:"),
					UserInput.enterPoint("Введите координаты 3 точки квадрата:"),
					UserInput.enterPoint("Введите координаты 4 точки квадрата:"));
		}

	}

}
