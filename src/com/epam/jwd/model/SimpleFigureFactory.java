package com.epam.jwd.model;

import java.util.List;
import com.epam.jwd.factory.FigureFactory;

public enum SimpleFigureFactory implements FigureFactory {

	INSTANCE;

	public Figure createFigure(FigureType type, List<Point> figureConstituents) {

		Figure figure = null;

		switch (type) {
		case RECTANGLE:
			figure = new Rectangle(figureConstituents);
			break;
		case PENTAGON:
			figure = new Pentagon(figureConstituents);
			break;
		case HEXAGON:
			figure = new Hexagon(figureConstituents);
			break;
		}

		return figure;

	}

}
