package com.epam.jwd.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.service.FigurePostProcessor;
import com.epam.jwd.model.Point;

public enum FigureExistencePostProcessor implements FigurePostProcessor {

	INSTANCE;

	@Override
	public Figure process(Figure figure) throws FigureException {
		System.out.println(figure.getClass().getName());
		int x1, x2, y1, y2, x3, y3;
		List<Point> temp = new ArrayList<Point>();

		System.out.println("size of points : " + figure.getPoints());
		for (int i = 0; i < figure.getPoints().size() - 1; i++) {

			x1 = figure.getPoints().get(i).getX();
			y1 = figure.getPoints().get(i).getY();
			x2 = figure.getPoints().get(i + 1).getX();
			y2 = figure.getPoints().get(i + 1).getY();
			temp.clear();
			temp.addAll(figure.getPoints());
			temp.remove(i);
			temp.remove(i);
			x3 = temp.get(0).getX();
			y3 = temp.get(0).getY();
			temp.remove(0);

			if ((x3 - x1) / (double) (x2 - x1) - (y3 - y1) / (double) (y2 - y1) == 0) {
				System.out.println("size of points : " + figure.getPoints());
				throw new FigureNotExistException(
						figure.getClass().getName() + " with specified coordinates doesn't exist");
			}
			boolean where = (x3 - x1) / (double) (x2 - x1) - (y3 - y1) / (double) (y2 - y1) > 0;
			for (Point p : temp) {

				if (((p.getX() - x1) / (double) (x2 - x1) - (p.getY() - y1) / (double) (y2 - y1) > 0) != where
						|| (p.getX() - x1) / (double) (x2 - x1) - (p.getY() - y1) / (double) (y2 - y1) == 0) {
					throw new FigureNotExistException(
							figure.getClass().getName() + " with specified coordinates doesn't exist");
				}
			}

		}
		return figure;
	}

}
