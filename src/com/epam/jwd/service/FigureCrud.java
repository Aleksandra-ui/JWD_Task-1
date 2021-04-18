package com.epam.jwd.service;

import java.util.List;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public interface FigureCrud {

	Figure create(FigureType type, List<Point> points) throws FigureException;

	void multiCreate(FigureType type, List<Point>... points) throws FigureException;

	void delete(int i);

	Figure findById(int i);

	Figure find(Figure figure);

	void update(int i, Figure figure);

	List<Figure> getFigures();

}
