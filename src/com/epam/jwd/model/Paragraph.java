package com.epam.jwd.model;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextComponent {

	private String value;
	private List<TextComponent> sentences = new ArrayList<TextComponent>();

	public Paragraph(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public List<TextComponent> getSentences() {
		// TODO Auto-generated method stub
		return sentences;
	}

	public void setSentences(List<TextComponent> sentences) {
		// TODO Auto-generated method stub
		this.sentences = sentences;
	}

	@Override
	public String toString() {
		return "Paragraph [value=" + value + ", sentences=" + sentences + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sentences == null) ? 0 : sentences.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paragraph other = (Paragraph) obj;
		if (sentences == null) {
			if (other.sentences != null)
				return false;
		} else if (!sentences.equals(other.sentences))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
