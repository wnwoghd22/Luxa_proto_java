enum eColor {
	red,
	green,
	blue,
}

public class Ring {
	int x, y;
	eColor color;	

	public Ring(int x, int y, int color) {
		this.x = x;
		this.y = y;
		switch(color) {
		case 0 : 
			this.color = eColor.red;
			break;
		case 1 : 
			this.color = eColor.green;
			break;
		case 2 : 
			this.color = eColor.blue;
			break;
		default :
			break;
		}
	}
	
	/*
	 * dir : true = clockwise, false = counterclockwise
	 */
	public void rotate(Whole[][] board, boolean dir) {
		if (dir) rotate_clock(board);
		else rotate_counter(board);
		
	}
	private void rotate_clock(Whole[][] board) {
		if (x % 2 == 1) { // is odd
			Bead temp = board[x- 1][y].GetBead();
			board[x- 1][y].SetBead(board[x][y - 1].GetBead());
			board[x][y - 1].SetBead(board[x + 1][y].GetBead());
			board[x + 1][y].SetBead(board[x + 1][y + 1].GetBead());
			board[x + 1][y + 1].SetBead(board[x][y + 1].GetBead());
			board[x][y + 1].SetBead(board[x - 1][y + 1].GetBead());
			board[x - 1][y + 1].SetBead(temp);
		} else {
			Bead temp = board[x- 1][y - 1].GetBead();
			board[x- 1][y - 1].SetBead(board[x][y - 1].GetBead());
			board[x][y - 1].SetBead(board[x + 1][y - 1].GetBead());
			board[x + 1][y - 1].SetBead(board[x + 1][y].GetBead());
			board[x + 1][y].SetBead(board[x][y + 1].GetBead());
			board[x][y + 1].SetBead(board[x - 1][y].GetBead());
			board[x - 1][y].SetBead(temp);
		}
	}
	private void rotate_counter(Whole[][] board) {
		if (x % 2 == 1) { // is odd
			Bead temp = board[x- 1][y].GetBead();
			board[x- 1][y].SetBead(board[x - 1][y + 1].GetBead());
			board[x - 1][y + 1].SetBead(board[x][y + 1].GetBead());
			board[x][y + 1].SetBead(board[x + 1][y + 1].GetBead());
			board[x + 1][y + 1].SetBead(board[x + 1][y].GetBead());
			board[x + 1][y].SetBead(board[x][y - 1].GetBead());
			board[x][y - 1].SetBead(temp);
		} else {
			Bead temp = board[x- 1][y - 1].GetBead();
			board[x - 1][y - 1].SetBead(board[x - 1][y].GetBead());
			board[x - 1][y].SetBead(board[x][y + 1].GetBead());
			board[x][y + 1].SetBead(board[x + 1][y].GetBead());
			board[x + 1][y].SetBead(board[x + 1][y - 1].GetBead());
			board[x + 1][y - 1].SetBead(board[x][y - 1].GetBead());
			board[x][y - 1].SetBead(temp);
		}
	}

	private boolean isMatch(Bead b) {
		boolean result = false;
		switch(color) {
		case red :
			if (b.HasRed()) result = true;
			break;
		case green :
			if (b.HasGreen()) result = true;
			break;
		case blue :
			if (b.HasBlue()) result = true;
			break;
		}

		return result;
	}

	public boolean GetComplete(Whole[][] board) {
		boolean result = false;

		if (x % 2 == 1) { // is odd
			result = (
				isMatch(board[x- 1][y].GetBead()) &&
				isMatch(board[x - 1][y + 1].GetBead()) &&
				isMatch(board[x][y + 1].GetBead()) &&
				isMatch(board[x + 1][y + 1].GetBead()) &&
				isMatch(board[x + 1][y].GetBead()) &&
				isMatch(board[x][y - 1].GetBead())
			);
		} else {
			result = (
				isMatch(board[x- 1][y - 1].GetBead()) &&
				isMatch(board[x - 1][y].GetBead()) &&
				isMatch(board[x][y + 1].GetBead()) &&
				isMatch(board[x + 1][y].GetBead()) &&
				isMatch(board[x + 1][y - 1].GetBead()) &&
				isMatch(board[x][y - 1].GetBead())
			);
		}

		return result;
	}

}