package com.epam.jwd.model;

import com.epam.jwd.strategy.RectanglePropertiesStrategy;

public class Rectangle extends Figure {

	private Point p1;
	private Point p2;
	private Point p3;
	private Point p4;

	protected Rectangle() {
	}

	protected Rectangle(Point... points) {
		this.p1 = points[0];
		this.p2 = points[1];
		this.p3 = points[2];
		this.p4 = points[3];
		this.figurePropertiesStrategy = RectanglePropertiesStrategy.getInstance();

	}

	public int calculateSquare() {
		return figurePropertiesStrategy.calculateSquare(p1, p2, p3, p4);
	}

	public int calculatePerimeter() {
		return figurePropertiesStrategy.calculatePerimeter(p1, p2, p3, p4);
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public Point getP3() {
		return p3;
	}

	public void setP3(Point p3) {
		this.p3 = p3;
	}

	public Point getP4() {
		return p4;
	}

	public void setP4(Point p4) {
		this.p4 = p4;
	}

	@Override
	public String toString() {
		return "Rectangle [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p1 == null) ? 0 : p1.hashCode());
		result = prime * result + ((p2 == null) ? 0 : p2.hashCode());
		result = prime * result + ((p3 == null) ? 0 : p3.hashCode());
		result = prime * result + ((p4 == null) ? 0 : p4.hashCode());
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
		Rectangle other = (Rectangle) obj;
		if (p1 == null) {
			if (other.p1 != null)
				return false;
		} else if (!p1.equals(other.p1))
			return false;
		if (p2 == null) {
			if (other.p2 != null)
				return false;
		} else if (!p2.equals(other.p2))
			return false;
		if (p3 == null) {
			if (other.p3 != null)
				return false;
		} else if (!p3.equals(other.p3))
			return false;
		if (p4 == null) {
			if (other.p4 != null)
				return false;
		} else if (!p4.equals(other.p4))
			return false;
		return true;
	}

}
