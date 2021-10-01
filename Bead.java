public class Bead {
	private boolean red;
	private boolean green;
	private boolean blue;

	public Bead(int r, int g, int b) {
		red = (r == 1) ? true : false;
		green = (g == 1) ? true : false;
		blue = (b == 1) ? true : false;
	}
	public boolean HasRed() { return red; }
	public boolean HasGreen() { return green; }
	public boolean HasBlue() { return blue; }
}