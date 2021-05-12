package com.epam.jwd.parsing;

import java.util.List;

import com.epam.jwd.model.TextComponent;

public interface Parser {

	List<TextComponent> parse(TextComponent tc);
	
}
