package com.epam.jwd.model;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextComponent {

	private String value;
	private List<TextComponent> components = new ArrayList<TextComponent>();

	public Sentence(String value) {
		this.value = value;
	}

	@Override
	public String getValue() {
		return value;
	}

	public List<TextComponent> getComponents() {
		return components;
	}

	public void setComponents(List<TextComponent> components) {
		this.components = components;
	}

	@Override
	public String toString() {
		return "Sentence [value=" + value + ", components=" + components + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((components == null) ? 0 : components.hashCode());
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
		Sentence other = (Sentence) obj;
		if (components == null) {
			if (other.components != null)
				return false;
		} else if (!components.equals(other.components))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
