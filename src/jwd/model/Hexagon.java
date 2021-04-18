package com.epam.jwd.model;

import java.util.List;

import com.epam.jwd.strategy.HexagonPropertiesStrategy;

public class Hexagon extends Figure {

	protected Hexagon() {

		this.figurePropertiesStrategy = HexagonPropertiesStrategy.getInstance();
	}

	protected Hexagon(List<Point> points) {

		super(points);
		this.figurePropertiesStrategy = HexagonPropertiesStrategy.getInstance();
	}

	public int calculateSquare() {
		return figurePropertiesStrategy.calculateSquare(getPoints());
	}

	public int calculatePerimeter() {
		return figurePropertiesStrategy.calculatePerimeter(getPoints());
	}

	@Override
	public String toString() {
		return "Hexagon [figurePropertiesStrategy=" + figurePropertiesStrategy + ", points=" + getPoints() + "]";
	}

}
