package com.epam.jwd.model;

import java.util.ArrayList;
import java.util.List;

import com.epam.jwd.strategy.FigurePropertiesStrategy;

public abstract class Figure {

	FigurePropertiesStrategy figurePropertiesStrategy;
	private List<Point> points = new ArrayList<Point>();

	protected Figure(List<Point> points) {
		this.setPoints(points);
	}

	public Figure() {
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoint(int i, Point point) {
		this.points.set(i, point);
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Point getPoint(int i) {
		return points.get(i);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((figurePropertiesStrategy == null) ? 0 : figurePropertiesStrategy.hashCode());
		result = prime * result + ((points == null) ? 0 : points.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figure other = (Figure) obj;
		if (figurePropertiesStrategy == null) {
			if (other.figurePropertiesStrategy != null)
				return false;
		} else if (!figurePropertiesStrategy.equals(other.figurePropertiesStrategy))
			return false;
		if (points == null) {
			if (other.points != null)
				return false;
		} else if (!points.equals(other.points))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Figure [figurePropertiesStrategy=" + figurePropertiesStrategy + ", points=" + points + "]";
	}

}
