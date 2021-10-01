import java.util.Scanner;

public class Controller {
	Scanner sc;
	public Controller() { sc = new Scanner(System.in); }

	String GetInput() {
		return sc.nextLine();
	}

	
}