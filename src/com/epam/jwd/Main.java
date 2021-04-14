package com.epam.jwd;

import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureFactory;
import com.epam.jwd.model.Point;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		String log4jConfPath = "logger.properties";
		PropertyConfigurator.configure(log4jConfPath);

		Random random = new Random();
		FigureFactory factory = new FigureFactory();
		Figure triangle = factory.newFigure(new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25));

		Figure rectangle = factory.newFigure(new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25));
		Figure pentagon = factory.newFigure(new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25));
		Figure hexagon = factory.newFigure(new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25),
				new Point(random.nextInt(50) - 25, random.nextInt(50) - 25));
		System.out.println(triangle);
		logger.info("printed triangle");
		System.out.println(rectangle);
		logger.info("printed rectangle");
		System.out.println(pentagon);
		logger.info("printed pentagon");
		System.out.println(hexagon);
		logger.info("printed hexagon");

	}

}
