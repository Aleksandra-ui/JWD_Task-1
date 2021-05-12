package com.epam.jwd.parsing;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.epam.jwd.model.Text;
import com.epam.jwd.model.TextComponent;

@RunWith(JUnit4.class)
public class TextParserTest {

	private final TextParser parser = TextParser.INSTANCE;

	@Test
	public void parse_returnsListOfParagraphs() {

		Text text = new Text("Hello!\n\tHow are you?");
		List<String> actualParagraphsValues = Arrays.asList(text.getValue().split("\n\t"));
		List<TextComponent> sentences = parser.parse(text);
		List<String> sentencesValues = sentences.stream().map(TextComponent::getValue).collect(Collectors.toList());
		assertEquals(actualParagraphsValues, sentencesValues);

	}

}
