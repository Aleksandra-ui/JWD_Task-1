package com.epam.jwd.expression;

@FunctionalInterface
public interface BitExpression {

	public int interpret(String expression);
	
}
