package task3;
import java.text.DecimalFormat;

public class Task3 {
	public static void main(String[] args) {
	    Point A= new Point();
	    A.x = Integer.parseInt(args[0]);
	    A.y = Integer.parseInt(args[1]);
	 
	    Point B = new Point();
	    B.x = Integer.parseInt(args[2]);
	    B.y = Integer.parseInt(args[3]);
	 
	    Point C = new Point();
	    C.x = Integer.parseInt(args[4]);
	    C.y = Integer.parseInt(args[5]);
	    double side1=Math.sqrt(Math.pow((B.x-A.x), 2)+Math.pow((B.y-A.y), 2));
	    double side2=Math.sqrt(Math.pow((C.x-A.x), 2)+Math.pow((C.y-A.y), 2));
	    double side3=Math.sqrt(Math.pow((C.x-B.x), 2)+Math.pow((C.y-B.y), 2));
	    double p=0.5*(side1+side2+side3);
	    DecimalFormat df = new DecimalFormat("#.##");
	    double square=Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
	    String roundSquare=df.format(square);
	    System.out.println("Площадь треугольника: "+roundSquare);
	    System.out.println(square);
	  }
		  static class Point {
			    double x;
			    double y;
			  }

			}

