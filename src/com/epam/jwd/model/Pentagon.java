package com.epam.jwd.model;

import java.util.List;
import com.epam.jwd.strategy.PentagonPropertiesStrategy;

public class Pentagon extends Figure {

	protected Pentagon() {
		this.figurePropertiesStrategy = PentagonPropertiesStrategy.getInstance();
	}

	protected Pentagon(List<Point> points) {
		super(points);
		this.figurePropertiesStrategy = PentagonPropertiesStrategy.getInstance();

	}

	public int calculateSquare() {
		return figurePropertiesStrategy.calculateSquare(getPoints());
	}

	public int calculatePerimeter() {
		return figurePropertiesStrategy.calculatePerimeter(getPoints());
	}

	@Override
	public String toString() {
		return "Pentagon [figurePropertiesStrategy=" + figurePropertiesStrategy + ", points=" + getPoints() + "]";
	}
}
