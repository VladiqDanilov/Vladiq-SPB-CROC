package task7;

public class IllegalPositionException extends Exception {
	public IllegalPositionException(int x, int y) {
		super("Incorrect chessboard position: (" + x + "; " + y + ")");
	}
}
