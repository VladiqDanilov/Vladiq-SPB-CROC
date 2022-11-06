package task4;

public class Task4 {
	public static void main(String[] args) {

		Rectangle sqa= new Rectangle(100, 100, 150, 200, "Car");
		Rectangle R1= new Rectangle(10, 15, -2, 1, "Nasa");
		Circle C1=new Circle(100, 100, 10, "Tree");
		Circle C2= new Circle(7, 5, 9, "Show");
		AnnotatedImage a1= new AnnotatedImage ("101", sqa, R1, C1, C2);
		for (int i=0; i<a1.getAnnotations().length; i++) {
			System.out.println(a1.getAnnotations()[i]);
		}
	}
}
class Figure{
	public Figure(String figure) {
		//super();
		this.figure = figure;
	}

	String figure;
}
class Annotation extends Figure{
	public String toString() {
		return "Annotation [label=" + label + ", figure=" + figure + "]";
	}
		String label;
		//String figure;
		Annotation(String label, String figure){
			super(figure);
			this.label=label;
		}
}
	


	class Rectangle extends Annotation{
		@Override
		public String toString() {
			return super.figure + " (X1=" + botLeftX + ", Y1=" + botLeftY + "), (X2=" + upRigthX
					+ ", Y2=" + upRigthY + "]): " + super.label;
		}
		int botLeftX, botLeftY;
		int upRigthX, upRigthY;
		public Rectangle(int botLeftX, int botLeftY, int upRigthX, int upRigthY, String label) {
			super(label, "Rectangle");
			this.botLeftX = botLeftX;
			this.botLeftY = botLeftY;
			this.upRigthX = upRigthX;
			this.upRigthY = upRigthY;
		}
	
}


	class Circle extends Annotation{
		int centX, centY, radius;
		public Circle(int centX, int centY, int radius, String label) {
			super(label, "Circle");
			this.centX = centX;
			this.centY = centY;
			this.radius = radius;
		}
		@Override
		public String toString() {
			return "Circle (centX=" + centX + ", centY=" + centY+"), radius=" + radius+": "+ super.label;
		}
	}
	class AnnotatedImage {
		private final String imagePath;
		private final Annotation[] annotations;
		
		public AnnotatedImage(String imagePath, Annotation... annotations) {
			this.imagePath = imagePath;
			this.annotations = annotations;
		}
		public String getImagePath() {
			return this.imagePath;
		}
		public Annotation[] getAnnotations() {
			return this.annotations;
		}
	}


