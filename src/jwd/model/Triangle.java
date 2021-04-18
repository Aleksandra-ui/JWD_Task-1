package com.epam.jwd.model;

import java.util.List;
import com.epam.jwd.strategy.TrianglePropertiesStrategy;

public class Triangle extends Figure {

	protected Triangle() {

		this.figurePropertiesStrategy = TrianglePropertiesStrategy.INSTANCE;
	}

	protected Triangle(List<Point> points) {
		super(points);
		this.figurePropertiesStrategy = TrianglePropertiesStrategy.INSTANCE;

	}

	public int calculateSquare() {
		return figurePropertiesStrategy.calculateSquare(getPoints());
	}

	public int calculatePerimeter() {
		return figurePropertiesStrategy.calculatePerimeter(getPoints());
	}

	@Override
	public String toString() {
		return "Triangle [figurePropertiesStrategy=" + figurePropertiesStrategy + ", points=" + getPoints() + "]";
	}

}
