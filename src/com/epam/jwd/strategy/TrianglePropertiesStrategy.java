package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.List;

public enum TrianglePropertiesStrategy implements FigurePropertiesStrategy {

	INSTANCE;

	@Override
	public int calculateSquare(List<Point> points) {

		int x1 = points.get(0).getX();
		int y1 = points.get(0).getY();
		int x2 = points.get(1).getX();
		int y2 = points.get(1).getY();
		int x3 = points.get(2).getX();
		int y3 = points.get(2).getY();

		return abs(x1 * y2 - y1 * x2 + x2 * y3 - y2 * x3 + x3 * y1 - y3 * x1) / 2;
	}

	@Override
	public int calculatePerimeter(List<Point> points) {

		int x1 = points.get(0).getX();
		int y1 = points.get(0).getY();
		int x2 = points.get(1).getX();
		int y2 = points.get(1).getY();
		int x3 = points.get(2).getX();
		int y3 = points.get(2).getY();
		double d1;
		double d2;
		double d3;

		d1 = sqrt(pow((x2 - x1), 2) + pow((y2 - y1), 2));
		d2 = sqrt(pow((x3 - x2), 2) + pow((y3 - y2), 2));
		d3 = sqrt(pow((x1 - x3), 2) + pow((y1 - y3), 2));

		return (int) (d1 + d2 + d3);

	}

}
