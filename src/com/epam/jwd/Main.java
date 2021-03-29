package com.epam.jwd;

import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.epam.jwd.bean.Line;
import com.epam.jwd.bean.Point;
import com.epam.jwd.bean.Square;
import com.epam.jwd.bean.Triangle;

public class Main {
	
	private static final Logger logger = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		
		String log4jConfPath = "logger.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		Point[] points = new Point[4];
		Line[] lines = new Line[2];
		Triangle[] triangles = new Triangle[2];
		Square[] squares = new Square[1];
		
		Random random = new Random();
		
		int i;
		for ( i = 0; i < points.length; i ++ ) {
			points[i] = new Point(random.nextInt(20), random.nextInt(20));
		}
		
		for ( i = 0; i < lines.length; i ++ ) {
			lines[i] = new Line(new Point(random.nextInt(20), random.nextInt(20)), new Point(random.nextInt(20), random.nextInt(20)));
		}
		
		for ( i = 0; i < triangles.length; i ++ ) {
			triangles[i] = new Triangle(new Point(random.nextInt(20), random.nextInt(20)), new Point(random.nextInt(20), random.nextInt(20)), new Point(random.nextInt(20), random.nextInt(20)));
		}
		
		for ( i = 0; i < squares.length; i ++ ) {
			squares[i] = new Square(UserInput.enterPoint("Введите координаты 1 точки квадрата:"), UserInput.enterPoint("Введите координаты 2 точки квадрата:"), UserInput.enterPoint("Введите координаты 3 точки квадрата:"), UserInput.enterPoint("Введите координаты 4 точки квадрата:"));
		}
		
		i = 0;
		do {
			System.out.println(points[i ++].toString());
			logger.info(String.format("Вывели %d точку на экран", i));
		} while ( i < points.length );
		
		for ( i = 0; i < lines.length; i ++ ) {
			if ( ! lines[i].getP1().equals(lines[i].getP2()) ) {
				System.out.println(lines[i].toString());
				logger.info(String.format("Вывели %d линию на экран", i + 1));
			}
			else {
				logger.error(String.format("Объект %s не является фигурой %s", lines[i].toString(), Line.class.getName()));;
			}
		}
		
		for ( i = 0; i < triangles.length; i ++ ) {
			if ( ! (lines[i].getP1().equals(triangles[i].getP2()) || triangles[i].getP1().equals(triangles[i].getP3()) || triangles[i].getP3().equals(triangles[i].getP2())) ) {
				System.out.println(triangles[i].toString());
				logger.info(String.format("Вывели %d треугольник на экран", i + 1));
			}
			else {
				logger.error(String.format("Треугольник %s не может существовать", triangles[i].toString()));;
			}
		}
		
		for ( i = 0; i < squares.length; i ++ ) {
			if (Validation.ifSquare(squares[i].getP1(), squares[i].getP2(), squares[i].getP3(), squares[i].getP4())) {
				System.out.println(triangles[i].toString());
				logger.info(String.format("Вывели %d квадрат на экран", i + 1));
			}
			else {
				logger.error(String.format("Объект %s не является квадратом", squares[i].toString()));;
			}
		}
		
	}

}
