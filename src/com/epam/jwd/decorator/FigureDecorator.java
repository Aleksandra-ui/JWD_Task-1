package com.epam.jwd.decorator;

import com.epam.jwd.factory.FigureFactory;

public abstract class FigureDecorator implements FigureFactory {

	final FigureFactory figureFactory;

	public FigureDecorator(FigureFactory figureFactory) {

		this.figureFactory = figureFactory;
	}

}
