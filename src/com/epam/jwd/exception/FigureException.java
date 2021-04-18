package com.epam.jwd.exception;

public class FigureException extends Exception {

	private static final long serialVersionUID = 8136498318222036508L;

	public FigureException() {
		super();
	}

	public FigureException(String message) {
		super(message);
	}

	public FigureException(Exception e) {
		super(e);
	}

	public FigureException(String message, Exception e) {
		super(message, e);
	}

}
