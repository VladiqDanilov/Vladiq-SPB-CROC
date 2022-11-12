package ru.croc.task4;

public class Annotation {
	private Figure figure;
	private String label;

	Annotation(Figure f, String _label) {
		figure = f;
		label = _label;
	}

	@Override
	public String toString() {
		return figure.toString() + label;
	}
}