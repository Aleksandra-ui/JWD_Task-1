package com.epam.jwd.parsing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.epam.jwd.model.TextComponent;
import com.epam.jwd.model.Paragraph;
import com.epam.jwd.model.Text;

public enum TextParser implements Parser {

	INSTANCE;

	@Override
	public List<TextComponent> parse(TextComponent text) {

		List<TextComponent> par = Arrays.asList(text.getValue().split("\t")).stream().map(s -> new Paragraph(s.trim()))
				.collect(Collectors.toList());
		((Text) text).setParagraphs(par);
		for (TextComponent p : par) {
			ParagraphParser.INSTANCE.parse(p);
		}

		return par;
	}

}
