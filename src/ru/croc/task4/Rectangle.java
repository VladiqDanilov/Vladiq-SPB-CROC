package ru.croc.task4;

public class Rectangle extends Figure {
	private double x1, y1;// с корд правого верхнего угла, наследуя фигуру

	public Rectangle(double... cords) {
		super.x = cords[0];
		super.y = cords[1];
		this.x1 = cords[2];
		this.y1 = cords[3];
	}

	@Override
	public String toString() {
		// return "Rectangle "+ x+","+y+"), "+"("+ x1+","+ y1+"): ";
		return "Rectangle(X1=" + x + ", Y1=" + y + "), (X2=" + x1 + ", Y2=" + y1 + "]): ";
	}
}