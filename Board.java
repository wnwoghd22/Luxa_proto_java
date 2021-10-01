import java.util.*;

public class Board {
	private Whole[][] board;
	private List<Ring> rings;
	private Renderer renderer;

	public Board(int col, int row) {
		board = new Whole[col][row];
		for(int i = 0; i < col; ++i)
			for(int j = 0; j < row; ++j)
				board[i][j] = new Whole();
		rings = new ArrayList<Ring>();
		renderer = new Renderer();
	}

	public void SetBeads(int x, int y, int r, int g, int b) {
		//System.out.println("call init");
		board[x][y].init(r, g, b);
	}

	public void AddRing(int x, int y, int color) {
		rings.add(new Ring(x, y, color));
	}

	public void Rotate(int ring, int dir) {
		rings.get(ring).rotate(board, dir == 0 ? true : false);
	}

	public boolean getComplete() {
		boolean result = true;
		for (Ring r : rings) if (!r.GetComplete(board)) return false;

		return result;
	}
	public void Render() {
		renderer.Render(board);
	}
}