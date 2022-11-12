package ru.croc.task4;

//исправил название пакета, неследование классов и сделал каждый класс - классом первого уровня
public class Main {

	public static void main(String[] args) {
		double cords1[] = { 2.0, 4.0, 3.0, 6.0 };
		double cords2[] = { 1.0, 8.0, 3.0, 9.0 };
		Rectangle r1 = new Rectangle(cords1);
		Rectangle r2 = new Rectangle(cords2);
		Circle c1 = new Circle(7.0, 5.0, 9.0);
		Circle c2 = new Circle(9.0, 3.0, 3.0);
		Annotation a1 = new Annotation(r1, "Nasa");
		Annotation a2 = new Annotation(r2, "Rocket");
		Annotation a3 = new Annotation(c1, "Tower");
		Annotation a4 = new Annotation(c2, "Launch");
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
	}

}
