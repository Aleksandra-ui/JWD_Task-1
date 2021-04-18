package com.epam.jwd.model;

import java.util.List;

import com.epam.jwd.strategy.RectanglePropertiesStrategy;

public class Rectangle extends Figure {

	
	
	protected Rectangle() {
		this.figurePropertiesStrategy = RectanglePropertiesStrategy.getInstance();
	}

	protected Rectangle(List<Point> points) {
		super(points);

		this.figurePropertiesStrategy = RectanglePropertiesStrategy.getInstance();

	}
	


	public int calculateSquare() {
		return figurePropertiesStrategy.calculateSquare(getPoints());
	}

	public int calculatePerimeter() {
		return figurePropertiesStrategy.calculatePerimeter(getPoints());
	}
	
	@Override
	public String toString() {
		return "Rectangle [figurePropertiesStrategy=" + figurePropertiesStrategy + ", points=" + getPoints() + "]";
	}

}
