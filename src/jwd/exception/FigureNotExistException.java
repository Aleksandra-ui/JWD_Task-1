package com.epam.jwd.exception;

public class FigureNotExistException extends FigureException {

	private static final long serialVersionUID = 4860420977910918237L;

	public FigureNotExistException() {
		super();
	}

	public FigureNotExistException(String message) {
		super(message);
	}

	public FigureNotExistException(Exception e) {
		super(e);
	}

	public FigureNotExistException(String message, Exception e) {
		super(message, e);
	}

}
