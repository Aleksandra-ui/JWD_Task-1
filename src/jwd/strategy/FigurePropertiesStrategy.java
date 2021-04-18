package com.epam.jwd.strategy;

import java.util.List;

import com.epam.jwd.model.Point;

public interface FigurePropertiesStrategy {

	int calculateSquare(List<Point> points);

	int calculatePerimeter(List<Point> points);

}
