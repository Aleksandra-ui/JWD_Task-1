package com.epam.jwd.service;

import java.util.List;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;

public interface FigurePreProcessor {
	boolean valid(FigureType type, List<Point> points);
}
