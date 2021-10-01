import java.util.Scanner;

public class Luxa {
	public static void main(String args[]) {
		FileManager fm = new FileManager();
		Controller ct = new Controller();

		Scanner selector = new Scanner(System.in);
		Board b = fm.readFile(selector.nextInt());

		while(!b.getComplete()) {
			b.Render();

			Scanner input = new Scanner(ct.GetInput());

			int ring = input.nextInt();
			int dir = input.nextInt();

			b.Rotate(ring, dir);

		}
		System.out.println("Clear!");
	}

	
}