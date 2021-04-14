package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class PentagonPropertiesStrategy implements FigurePropertiesStrategy {

	private static PentagonPropertiesStrategy instance = new PentagonPropertiesStrategy();

	private PentagonPropertiesStrategy() {
	}

	public static PentagonPropertiesStrategy getInstance() {
		return instance;

	}

	@Override
	public int calculateSquare(Point... points) {

		int x1 = points[0].getX();
		int y1 = points[0].getY();
		int x2 = points[1].getX();
		int y2 = points[1].getY();
		int x3 = points[2].getX();
		int y3 = points[2].getY();
		int x4 = points[3].getX();
		int y4 = points[3].getY();
		int x5 = points[3].getX();
		int y5 = points[3].getY();

		return abs(x1 * y2 - y1 * x2 + x2 * y3 - y2 * x3 + x3 * y4 - y3 * x4 + x4 * y5 - y4 * x5 + x1 * y5 - y1 * x5)
				/ 2;
	}

	@Override
	public int calculatePerimeter(Point... points) {

		int x1 = points[0].getX();
		int y1 = points[0].getY();
		int x2 = points[1].getX();
		int y2 = points[1].getY();
		int x3 = points[2].getX();
		int y3 = points[2].getY();
		int x4 = points[3].getX();
		int y4 = points[3].getY();
		int x5 = points[4].getX();
		int y5 = points[4].getY();
		double d1;
		double d2;
		double d3;
		double d4;
		double d5;

		d1 = sqrt(pow((x2 - x1), 2) + pow((y2 - y1), 2));
		d2 = sqrt(pow((x3 - x2), 2) + pow((y3 - y2), 2));
		d3 = sqrt(pow((x4 - x3), 2) + pow((y4 - y3), 2));
		d4 = sqrt(pow((x4 - x5), 2) + pow((y4 - y5), 2));
		d5 = sqrt(pow((x5 - x1), 2) + pow((y5 - y1), 2));

		return (int) (d1 + d2 + d3 + d4 + d5);

	}

}
