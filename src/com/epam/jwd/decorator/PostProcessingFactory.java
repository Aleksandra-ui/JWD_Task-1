package com.epam.jwd.decorator;

import java.util.List;
import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.FigureExistencePostProcessor;

public class PostProcessingFactory extends FigureDecorator {
	private final FigureExistencePostProcessor postProcessor = FigureExistencePostProcessor.INSTANCE;

	public PostProcessingFactory(FigureFactory figureFactory) {
		super(figureFactory);
	}

	@Override
	public Figure createFigure(FigureType type, List<Point> figureConstituents) throws FigureException {
		Figure figure = figureFactory.createFigure(type, figureConstituents);
		figure = postProcessor.process(figure);
		return figure;
	}
}
