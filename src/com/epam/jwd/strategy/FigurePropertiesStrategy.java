package com.epam.jwd.strategy;

import com.epam.jwd.model.Point;

public interface FigurePropertiesStrategy {

	int calculateSquare(Point... points);

	int calculatePerimeter(Point... points);

}
