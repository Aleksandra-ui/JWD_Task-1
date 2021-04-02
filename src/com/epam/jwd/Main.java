package com.epam.jwd;

import java.util.Random;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.epam.jwd.bean.Line;
import com.epam.jwd.bean.Point;
import com.epam.jwd.bean.Square;
import com.epam.jwd.bean.Triangle;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		String log4jConfPath = "logger.properties";
		PropertyConfigurator.configure(log4jConfPath);

		Point[] points = new Point[4];
		Line[] lines = new Line[2];
		Triangle[] triangles = new Triangle[2];
		Square[] squares = new Square[1];

		Logic logic = new Logic();
		logic.fillArray(points);
		logic.fillArray(lines);
		logic.fillArray(squares);

		int i = 0;
		do {
			System.out.println(points[i++].toString());
			logger.info("Вывели {} точку на экран", i);
		} while (i < points.length);

		for (i = 0; i < lines.length; i++) {
			if (!lines[i].getP1().equals(lines[i].getP2())) {
				System.out.println(lines[i].toString());
				logger.info("Вывели {} линию на экран", i + 1);
			} else {
				logger.error("Объект {} не является фигурой {}", lines[i].toString(), Line.class.getName());
			}
		}

		for (i = 0; i < triangles.length; i++) {
			if (!(lines[i].getP1().equals(triangles[i].getP2()) || triangles[i].getP1().equals(triangles[i].getP3())
					|| triangles[i].getP3().equals(triangles[i].getP2()))) {
				System.out.println(triangles[i].toString());
				logger.info("Вывели {} треугольник на экран", i + 1);
			} else {
				logger.error("Треугольник {} не может существовать", triangles[i].toString());
			}
		}

		for (i = 0; i < squares.length; i++) {
			if (Validation.ifSquare(squares[i].getP1(), squares[i].getP2(), squares[i].getP3(), squares[i].getP4())) {
				System.out.println(triangles[i].toString());
				logger.info("Вывели {} квадрат на экран", i + 1);
			} else {
				logger.error("Объект {} не является квадратом", squares[i].toString());
			}
		}

	}

}
