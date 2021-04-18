package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.List;

public class RectanglePropertiesStrategy implements FigurePropertiesStrategy {

	private static volatile RectanglePropertiesStrategy instance;

	private RectanglePropertiesStrategy() {
	}

	public static RectanglePropertiesStrategy getInstance() {

		if (instance == null) {
			synchronized (RectanglePropertiesStrategy.class) {
				if (instance == null) {
					instance = new RectanglePropertiesStrategy();
				}
			}
		}
		return instance;

	}

	@Override
	public int calculateSquare(List<Point> points) {

		int x1 = points.get(0).getX();
		int y1 = points.get(0).getY();
		int x2 = points.get(1).getX();
		int y2 = points.get(1).getY();
		int x3 = points.get(2).getX();
		int y3 = points.get(2).getY();
		int x4 = points.get(3).getX();
		int y4 = points.get(3).getY();

		return abs(x1 * y2 - y1 * x2 + x2 * y3 - y2 * x3 + x3 * y4 - y3 * x4 + x4 * y1 - y4 * x1) / 2;
	}

	@Override
	public int calculatePerimeter(List<Point> points) {

		int x1 = points.get(0).getX();
		int y1 = points.get(0).getY();
		int x2 = points.get(1).getX();
		int y2 = points.get(1).getY();
		int x3 = points.get(2).getX();
		int y3 = points.get(2).getY();
		int x4 = points.get(3).getX();
		int y4 = points.get(3).getY();
		double d1;
		double d2;
		double d3;
		double d4;

		d1 = sqrt(pow((x2 - x1), 2) + pow((y2 - y1), 2));
		d2 = sqrt(pow((x3 - x2), 2) + pow((y3 - y2), 2));
		d3 = sqrt(pow((x4 - x3), 2) + pow((y4 - y3), 2));
		d4 = sqrt(pow((x4 - x1), 2) + pow((y4 - y1), 2));

		return (int) (d1 + d2 + d3 + d4);

	}

}
