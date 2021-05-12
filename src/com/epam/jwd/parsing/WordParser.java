package com.epam.jwd.parsing;

import java.util.ArrayList;

import java.util.List;

import com.epam.jwd.model.Symbol;
import com.epam.jwd.model.TextComponent;
import com.epam.jwd.model.Word;

public enum WordParser implements Parser {

	INSTANCE;

	@Override
	public List<TextComponent> parse(TextComponent word) {

		List<TextComponent> symbols = new ArrayList<>();

		char[] chars = word.getValue().toCharArray();
		for (char symbol : chars) {
			symbols.add(new Symbol(String.valueOf(symbol)));
		}

		((Word) word).setSymbols(symbols);

		return symbols;

	}

}
