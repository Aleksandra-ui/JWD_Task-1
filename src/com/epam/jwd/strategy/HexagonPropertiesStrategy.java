package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

import java.util.List;

public class HexagonPropertiesStrategy implements FigurePropertiesStrategy {

	private static HexagonPropertiesStrategy instance = new HexagonPropertiesStrategy();

	private HexagonPropertiesStrategy() {
	}

	public static HexagonPropertiesStrategy getInstance() {
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
		int x5 = points.get(4).getX();
		int y5 = points.get(4).getY();
		int x6 = points.get(5).getX();
		int y6 = points.get(5).getY();

		return abs(x1 * y2 - y1 * x2 + x2 * y3 - y2 * x3 + x3 * y4 - y3 * x4 + x4 * y5 - y4 * x5 + x6 * y5 - y6 * x5
				+ x6 * y1 - y6 * x1) / 2;
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
		int x5 = points.get(4).getX();
		int y5 = points.get(4).getY();
		int x6 = points.get(5).getX();
		int y6 = points.get(5).getY();
		double d1;
		double d2;
		double d3;
		double d4;
		double d5;
		double d6;

		d1 = sqrt(pow((x2 - x1), 2) + pow((y2 - y1), 2));
		d2 = sqrt(pow((x3 - x2), 2) + pow((y3 - y2), 2));
		d3 = sqrt(pow((x4 - x3), 2) + pow((y4 - y3), 2));
		d4 = sqrt(pow((x4 - x5), 2) + pow((y4 - y5), 2));
		d5 = sqrt(pow((x6 - x5), 2) + pow((y6 - y5), 2));
		d6 = sqrt(pow((x6 - x1), 2) + pow((y6 - y1), 2));

		return (int) (d1 + d2 + d3 + d4 + d5 + d6);

	}

}
