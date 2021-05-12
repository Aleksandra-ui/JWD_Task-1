package com.epam.jwd.parsing;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.epam.jwd.model.Paragraph;

import com.epam.jwd.model.TextComponent;

@RunWith(JUnit4.class)
public class ParagraphParserTest {

	private final ParagraphParser parser = ParagraphParser.INSTANCE;

	@Test
	public void parse_returnsListOfSentences_whenEachSentenceBeginsWithCapitalLetter() {

		Paragraph par = new Paragraph("Hello! How are you?");
		List<TextComponent> sentences = parser.parse(par);
		for (TextComponent s : sentences) {
			assertTrue(Character.isUpperCase(s.getValue().charAt(0)));
		}

	}

}
