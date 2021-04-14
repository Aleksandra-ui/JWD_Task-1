package com.epam.jwd.model;

public class FigureFactory {

	public Figure newFigure(Point... points) {

		switch (points.length) {
		case 3:
			return new Triangle(points);
		case 4:
			return new Rectangle(points);
		case 5:
			return new Pentagon(points);
		case 6:
			return new Hexagon(points);
		default:
			return null;

		}
	}

}
