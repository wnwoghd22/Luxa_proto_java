import java.util.List;

public class Board {
	private Whole[][] board;
	private List<Ring> rings;

	public Board(int col, int row) {
		board = new Whole[col][row];
	}

	public void SetBeads(int col, int row, int r, int g, int b) {
		board[col][row].init(r, g, b);
	}

	public void AddRing(int x, int y, int color) {
		rings.add(new Ring(x, y, color));
	}

	
}