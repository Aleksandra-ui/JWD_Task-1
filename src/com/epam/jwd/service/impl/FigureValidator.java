package com.epam.jwd.service.impl;

import java.util.List;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigurePreProcessor;

public enum FigureValidator implements FigurePreProcessor {

	INSTANCE;

	@Override
	public boolean valid(FigureType type, List<Point> points) {

		switch (type) {
		case RECTANGLE:
			if (points.size() == 4) {
				System.out.println("rectangle has 4 points");
				return true;
			}
			break;
		case PENTAGON:
			if (points.size() == 5) {
				System.out.println("pentagon has 5 points");
				return true;
			}
			break;
		case HEXAGON:
			if (points.size() == 6) {
				System.out.println("points size 6");
				return true;
			}
			break;

		}
		System.out.println("no valid");
		return false;
	}

}
