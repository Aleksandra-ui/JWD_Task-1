package com.epam.jwd.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.impl.FigureCrudImpl;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) throws FigureException {

		String log4jConfPath = "logger.properties";
		PropertyConfigurator.configure(log4jConfPath);

		Random random = new Random();
		FigureCrudImpl crud = new FigureCrudImpl();

		List<Point> forRectangle1 = new ArrayList<>();

		forRectangle1.add(new Point(3, 5));
		forRectangle1.add(new Point(8, 2));
		forRectangle1.add(new Point(6, -7));
		forRectangle1.add(new Point(-5, -2));

		List<Point> forRectangle2 = new ArrayList<>();

		forRectangle2.add(new Point(0, 0));
		forRectangle2.add(new Point(0, 2));
		forRectangle2.add(new Point(2, 2));
		forRectangle2.add(new Point(2, 0));

		List<Point> forPentagon = new ArrayList<>();

		forPentagon.add(new Point(0, 0));
		forPentagon.add(new Point(0, 2));
		forPentagon.add(new Point(1, 3));
		forPentagon.add(new Point(2, 2));
		forPentagon.add(new Point(2, 0));
		List<Point> forHexagon = new ArrayList<>();

		forHexagon.add(new Point(0, 0));
		forHexagon.add(new Point(0, 2));
		forHexagon.add(new Point(1, 3));
		forHexagon.add(new Point(2, 2));
		forHexagon.add(new Point(2, 0));
		forHexagon.add(new Point(1, -1));

		crud.create(FigureType.RECTANGLE, forRectangle1);
		logger.info("Created rectangle");
		crud.create(FigureType.PENTAGON, forPentagon);
		logger.info("Created pentagon");
		crud.create(FigureType.HEXAGON, forHexagon);
		logger.info("Created hexagon");
		crud.delete(0);
		logger.info("Deleted first element from the list");
		crud.multiCreate(FigureType.RECTANGLE, forRectangle1, forRectangle2);
		logger.info("Created two rectangles");
		Figure figure = crud.new Search().addA(0, 0).addF(1, -1).find();
		System.out.println(figure);
		logger.info("Found a figure");
		

		System.out.println(crud.getFigures());
		logger.info("Printed figures list");

	}

}
