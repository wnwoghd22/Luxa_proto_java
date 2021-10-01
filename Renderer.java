public class Renderer {
	public Renderer() {}

	public void Render(Whole[][] board) {
		for (int i = 0; i < board.length; ++i) {
			if (i % 2 == 0) System.out.print(" ");
			for (int j = 0; j < board[i].length; ++j) {
				if (board[i][j].GetBead() == null)
					System.out.print("  ");
				else {
					boolean _r = board[i][j].GetBead().HasRed();
					boolean _g = board[i][j].GetBead().HasGreen();
					boolean _b = board[i][j].GetBead().HasBlue();

					if (_r) {
						if (_g) {
							if (_b) System.out.print("W");
							else System.out.print("Y");
						} else
							if (_b) System.out.print("P");
							else System.out.print("R");
					} else {
						if (_g) {
							if (_b) System.out.print("S");
							else System.out.print("G");
						} else {
							if (_b) System.out.print("B");
							else System.out.print(" ");
						}
					}
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}