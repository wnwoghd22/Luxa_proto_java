import java.util.Scanner;

public class Luxa {
	public static void main(String args[]) {
		FileManager fm = new FileManager();
		Controller ct = new Controller();

		Board b = fm.readFile(1);

		while(!b.getComplete()) {
			b.Render();

			Scanner input = new Scanner(ct.GetInput());

			int ring = input.nextInt();
			int dir = input.nextInt();

			b.Rotate(ring, dir);

		}
	}

	
}