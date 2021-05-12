package com.epam.jwd.parsing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.jwd.model.Sentence;
import com.epam.jwd.model.TextComponent;
import com.epam.jwd.model.Paragraph;

public enum ParagraphParser implements Parser {

	INSTANCE;

	@Override
	public List<TextComponent> parse(TextComponent paragraph) {

		int start = 0;
		int end;
		Sentence sntnc;
		String sntncTemplate = "[.{1,3}!?]\\s*[A-ZА-Я]";
		List<TextComponent> sentences = new ArrayList<>();

		Matcher m = Pattern.compile(sntncTemplate).matcher(paragraph.getValue());

		while (m.find()) {
			end = m.start();
			sntnc = new Sentence(paragraph.getValue().substring(start, end + 1));
			sentences.add(sntnc);
			start = m.end();
		}

		if (sentences.isEmpty()) {
			sntnc = new Sentence(paragraph.getValue());
			sentences.add(sntnc);
		} else {
			sntnc = new Sentence(paragraph.getValue().substring(start - 1, paragraph.getValue().length()));
			sentences.add(sntnc);
		}

		((Paragraph) paragraph).setSentences(sentences);

		for (TextComponent s : sentences) {
			SentenceParser.INSTANCE.parse(s);
		}

		return sentences;

	}

}
