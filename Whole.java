public class Whole {
	private Bead current;

	public Whole() {
		current = null;
	}
	public void init(int r, int g, int b) {
		//System.out.println("create bead");
		current = new Bead(r, g, b);
	}
	
	public Bead GetBead() {
		return current;
	}
	public void SetBead(Bead b) {
		current = b;
	}

}