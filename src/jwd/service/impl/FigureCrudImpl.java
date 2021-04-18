package com.epam.jwd.service.impl;

import com.epam.jwd.service.FigureCrud;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.ApplicationContext;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Hexagon;
import com.epam.jwd.model.Pentagon;
import com.epam.jwd.model.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FigureCrudImpl implements FigureCrud {

	FigureFactory factory = ApplicationContext.createFigureFactory();
	private List<Figure> figures = new ArrayList<Figure>();

	public class Search {

		Stream<Figure> found = figures.stream();

		public Search addA(int x, int y) {
			found = found.filter(f -> (((Figure) f).getPoint(0).getX() == x && ((Figure) f).getPoint(0).getY() == y));
			return this;
		}

		public Search addB(int x, int y) {
			found = found.filter(f -> (((Figure) f).getPoint(1).getX() == x && ((Figure) f).getPoint(1).getY() == y));
			return this;
		}

		public Search addC(int x, int y) {
			found = found.filter(f -> (((Figure) f).getPoint(2).getX() == x && ((Figure) f).getPoint(2).getY() == y));
			return this;
		}

		public Search addD(int x, int y) {
			found = found.filter(f -> (((Figure) f).getPoint(3).getX() == x && ((Figure) f).getPoint(3).getY() == y));
			return this;
		}

		public Search addE(int x, int y) {

			found = found.filter(f -> f instanceof Pentagon || f instanceof Hexagon)
					.filter(f -> (((Figure) f).getPoint(4).getX() == x && ((Figure) f).getPoint(4).getY() == y));
			return this;

		}

		public Search addF(int x, int y) {

			found = found.filter(f -> f instanceof Hexagon)
					.filter(f -> (((Hexagon) f).getPoint(5).getX() == x && ((Figure) f).getPoint(5).getY() == y));

			return this;
		}

		public Figure find() {

			return found.findAny().get();
		}

	}

	public Figure create(FigureType type, List<Point> points) throws FigureException {
		Figure figure = factory.createFigure(type, points);
		figures.add(figure);
		return figure;
	}

	public void multiCreate(FigureType type, List<Point>... points) throws FigureException {
		for (List<Point> p : points) {
			create(type, p);
		}

	}

	public void delete(int i) {
		figures.remove(i);

	}

	public Figure findById(int i) {
		return figures.get(i);

	}

	public Figure find(Figure figure) {
		int i = figures.indexOf(figure);
		return figures.get(i);

	}

	public void update(int i, Figure figure) {

		figures.set(i, figure);
	}

	public List<Figure> getFigures() {
		return figures;
	}
}