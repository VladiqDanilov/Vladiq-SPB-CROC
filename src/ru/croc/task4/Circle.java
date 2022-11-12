package ru.croc.task4;

public class Circle extends Figure {
	private double r;//наследуя фигуру + коректный вывод

	public Circle(double... cords) {
		super.x = cords[0];
		super.y = cords[1];
		this.r = cords[2];
	}

	@Override
	public String toString() {
		return "Circle (X1=" + x + " , Y1=" + y + " ), radius=" + r + ": ";
	}
}
