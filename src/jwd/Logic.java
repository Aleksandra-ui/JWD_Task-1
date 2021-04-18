package com.epam.jwd;

import java.util.Random;

import com.epam.jwd.model.Line;
import com.epam.jwd.model.Point;

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

}
