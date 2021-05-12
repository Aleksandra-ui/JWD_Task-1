package com.epam.jwd.model;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextComponent {

	private String value;
	private List<TextComponent> paragraphs = new ArrayList<TextComponent>();

	public Text(String value) {

		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	public List<TextComponent> getParagraphs() {
		return paragraphs;
	}

	public void setParagraphs(List<TextComponent> paragraphs) {
		this.paragraphs = paragraphs;
	}

	@Override
	public String toString() {
		return "Text [value=" + value + ", paragraphs=" + paragraphs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paragraphs == null) ? 0 : paragraphs.hashCode());
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
		Text other = (Text) obj;
		if (paragraphs == null) {
			if (other.paragraphs != null)
				return false;
		} else if (!paragraphs.equals(other.paragraphs))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
