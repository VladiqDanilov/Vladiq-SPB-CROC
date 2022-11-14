package task7;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*реазизована половина задания
 * Сделаны: определения класса, Exception, переопределены методы, сделан фабричный метод
 */

public class Task7a {
	static ArrayList<Integer> mX = new ArrayList<Integer>();
	static ArrayList<Integer> mY = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		List<String> spotPos = Arrays.asList("g8", "e7", "c8");
		for (int i = 0; i < spotPos.size(); i++) {
			String Pos = spotPos.get(i);
			mX.add(Spot.parse(Pos).x);
			mY.add(Spot.parse(Pos).y);
			//System.out.println(Spot.parse(Pos));
			}
		if (knightAbleGo(mX, mY)) {
		System.out.print("OK");
			}
		
		
		//for (int j = 0; j < spotPos.size(); j++) {

		//}

		try {
			Spot zeroSpot = new Spot(4, 7);
			//System.out.println(zeroSpot);
		} catch (Exception e) {
			System.out.println(e);

		}
	}

	public static class Spot {
		int x;
		int y;

		@Override
		public String toString() {
			int aAlf = (int) 'a';
			return "" + (char) (x + aAlf) + (y + 1);
		}

		public Spot(int x, int y) throws Exception {

			if (x < 0 || x > 7 || y < 0 || y > 7) {
				throw new IllegalPositionException(x, y);
			}

			this.x = x;
			this.y = y;
		}

		public static Spot parse(String Pos) throws Exception {
			int newx = (int) Pos.charAt(0) - 97;
			int newy = (Pos.charAt(1) - '0') - 1;
			if (newx < 0 || newx > 7 || newy < 0 || newy > 7 && Pos.length() < 2) {
				throw new IllegalPositionException(newx, newy);
			}
			return new Spot(newx, newy);

		}
	}
	public static Boolean knightAbleGo(ArrayList<Integer> x, ArrayList<Integer> y) {
		for(int n=1; n<x.size(); n++) {
			
			if ((x.get(n-1)-2==x.get(n) || y.get(n-1)+1==y.get(n))||(y.get(n-1)-2==y.get(n) && x.get(n-1)-2==x.get(n))) {
			return false;
				}
		}
		return true;
	}
}
/*
 * public class Board {
 * 
 * Spot[][] boxes;
 * 
 * 
 * public Spot getBox(int x, int y) throws Exception { if (x < 0 || x > 7 || y <
 * 0 || y > 7) { throw new Exception("Index out of bound"); }
 * 
 * return boxes[x][y]; }
 * 
 * @Override public String toString() { return "Board [boxes=" +
 * Arrays.toString(boxes) + "]"; } }
 */
