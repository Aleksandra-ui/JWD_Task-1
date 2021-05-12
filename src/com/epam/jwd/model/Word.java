package com.epam.jwd.model;

import java.util.ArrayList;
import java.util.List;

public class Word implements TextComponent {

	private String value;
	private List<TextComponent> symbols = new ArrayList<TextComponent>();

	public Word(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	public List<TextComponent> getSymbols() {

		return symbols;
	}

	public void setSymbols(List<TextComponent> symbols) {

		this.symbols = symbols;
	}

	@Override
	public String toString() {
		return "Word [value=" + value + ", symbols=" + symbols + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((symbols == null) ? 0 : symbols.hashCode());
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
		Word other = (Word) obj;
		if (symbols == null) {
			if (other.symbols != null)
				return false;
		} else if (!symbols.equals(other.symbols))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
