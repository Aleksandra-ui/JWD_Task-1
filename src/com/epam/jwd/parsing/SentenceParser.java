package com.epam.jwd.parsing;

import java.util.ArrayList;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.PunctuationMark;
import com.epam.jwd.model.Sentence;
import com.epam.jwd.model.TextComponent;
import com.epam.jwd.model.Word;

public enum SentenceParser implements Parser {

	INSTANCE;

	@Override
	public List<TextComponent> parse(TextComponent sentence) {

		String WORD_TEMPLATE = "[a-zA-Zа-яА-Я-]+";

		List<TextComponent> sentenceComponents = new ArrayList<>();
		Pattern wordPattern;
		Matcher wordMatcher;
		Word word;

		String sntnc = sentence.getValue();

		// разбить на лексемы и создать из них массив tokens
		// пройтись по массиву,проверяя каждый элемент:
		// если он состоит только из букв и дефиса,добавлять его в конечный список
		// иначе:если он содержит буквы,это смесь знака препинания и слова.
		// если не содержит,это битовое выражение.

		String[] tokens = sntnc.split(" ");

		for (String token : tokens) {

			if (token.matches(WORD_TEMPLATE)) {

				word = new Word(token);
				WordParser.INSTANCE.parse(word);
				sentenceComponents.add(word);

			} else {

				wordPattern = Pattern.compile(WORD_TEMPLATE);
				wordMatcher = wordPattern.matcher(token);
				if (wordMatcher.find()) {

					word = new Word(parseWord(token));
					WordParser.INSTANCE.parse(word);
					sentenceComponents.add(word);
					sentenceComponents.addAll(
							parsePunctMark(token).stream().map(PunctuationMark::new).collect(Collectors.toList()));

				} else {

					// добавить парсинг битовых выражений
					sentenceComponents.add(new Figure(0));

				}

			}

		}

		((Sentence) sentence).setComponents(sentenceComponents);

		return null;
	}

	private String parseWord(String input) {

		String word = input.replaceAll(",", "").replaceAll(":", "").replaceAll(";", "").replaceAll("\\)", "")
				.replaceAll("\\(", "").replaceAll("\\.", "").replaceAll("!", "").replaceAll("\\?", "");
		return word;

	}

	private List<String> parsePunctMark(String input) {

		List<String> punctMarks = new ArrayList<String>();
		String MARK_TEMPLATE = "[,:;\\)\\(\\.!?]{1}";
		Pattern pattern = Pattern.compile(MARK_TEMPLATE);
		Matcher m = pattern.matcher(input);
		while (m.find()) {
			punctMarks.add(m.group());
		}

		return punctMarks;

	}

}
