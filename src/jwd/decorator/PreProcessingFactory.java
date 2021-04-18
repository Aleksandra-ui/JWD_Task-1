package com.epam.jwd.decorator;

import java.util.List;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.FigureValidator;

public class PreProcessingFactory extends FigureDecorator {

	private final FigureValidator preProcessor = FigureValidator.INSTANCE;

	public PreProcessingFactory(FigureFactory figureFactory) {
		super(figureFactory);

	}

	@Override
	public Figure createFigure(FigureType type, List<Point> figureConstituents) throws FigureException {
		if (preProcessor.valid(type, figureConstituents)) {
			System.out.println("valid");
			return figureFactory.createFigure(type, figureConstituents);
		} else
			throw new FigureNotExistException("Can not create a figure");

	}

}
