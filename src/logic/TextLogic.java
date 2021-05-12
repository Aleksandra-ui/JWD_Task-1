package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.epam.jwd.model.Paragraph;
import com.epam.jwd.model.Sentence;
import com.epam.jwd.model.Text;
import com.epam.jwd.model.TextComponent;

public enum TextLogic {

	INSTANCE;

	public Text sortParByNumOfSntncs(Text text) {

		List<TextComponent> paragraphs = text.getParagraphs();
		Collections.sort(paragraphs, Comparator.comparing(p -> ((Paragraph) p).getSentences().size()));
		List<String> values = paragraphs.stream().map(TextComponent::getValue).collect(Collectors.toList());

		String value = "\t".concat(String.join("\n\t", values));
		Text text2 = new Text(value);
		text2.setParagraphs(paragraphs);
		return text2;

	}

	public Text sortCompOfSntncsByLength(Text text) {

		List<TextComponent> sentences = new ArrayList<>();
		List<TextComponent> comps = new ArrayList<>();
		List<TextComponent> paragraphs = new ArrayList<>();
		Sentence tempSntnc;
		Paragraph tempPar;
		String sntncValue;
		String parValue;
		String[] newSntnc;
		String[] newPar;
		String[] newText;
		String textValue;
		Text text2;

		for (TextComponent p : text.getParagraphs()) {

			for (TextComponent s : ((Paragraph) p).getSentences()) {

				comps.addAll(((Sentence) s).getComponents());
				comps.sort(Comparator.comparing(c -> c.getValue().length()));
				newSntnc = comps.stream().map(TextComponent::getValue).toArray(String[]::new);
				sntncValue = String.join(" ", newSntnc);
				tempSntnc = new Sentence(sntncValue);
				((Sentence) tempSntnc).setComponents(comps);
				sentences.add(tempSntnc);
				comps.clear();

			}

			newPar = sentences.stream().map(TextComponent::getValue).toArray(String[]::new);
			parValue = String.join(" ", newPar);
			tempPar = new Paragraph(parValue);
			((Paragraph) tempPar).setSentences(sentences);
			paragraphs.add(tempPar);
			sentences.clear();

		}

		newText = paragraphs.stream().map(TextComponent::getValue).toArray(String[]::new);
		textValue = "\t".concat(String.join("\n\t", newText));
		text2 = new Text(textValue);
		text2.setParagraphs(paragraphs);
		return text2;

	}

	public Text sortTokensOfSntncsByLength(Text text) {

		String sentence;
		String[] tokens;
		Sentence temp;
		String sntncValue;
		String[] newPar;
		String parValue;
		TextComponent tempPar;
		String[] newText;
		String textValue;
		Text text2;
		List<TextComponent> sentences = new ArrayList<>();
		List<TextComponent> paragraphs = new ArrayList<>();

		for (TextComponent p : text.getParagraphs()) {

			for (TextComponent s : ((Paragraph) p).getSentences()) {

				sentence = s.getValue();
				tokens = sentence.split(" ");
				Arrays.sort(tokens, Comparator.comparing(t -> t.length()));
				sntncValue = String.join(" ", tokens);
				System.out.println(String.join(" ", tokens));
				temp = new Sentence(sntncValue);
				sentences.add(temp);

			}

			newPar = sentences.stream().map(TextComponent::getValue).toArray(String[]::new);
			parValue = String.join(" ", newPar);
			tempPar = new Paragraph(parValue);
			((Paragraph) tempPar).setSentences(sentences);
			paragraphs.add(tempPar);
			sentences.clear();

		}

		newText = paragraphs.stream().map(TextComponent::getValue).toArray(String[]::new);
		textValue = String.join("\n\t", newText);
		text2 = new Text(textValue);
		text2.setParagraphs(paragraphs);
		return text2;

	}

	public Text sortWordsBySymbNum(Text text, String symbol) {

		String[] tokens;
		Text text2;
		String value;

		tokens = text.getValue().split(" ");
		Arrays.sort(tokens);
		Arrays.sort(tokens, Collections.reverseOrder(Comparator.comparing(t -> symbCount(t, symbol))));
		value = String.join(" ", tokens);
		text2 = new Text(value);

		return text2;

	}

	private Integer symbCount(String token, String symb) {
		Integer c = 0;
		Matcher m = Pattern.compile(symb).matcher(token);
		while (m.find()) {
			c++;
		}
		return c;
	}

}
