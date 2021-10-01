import java.io.File;
import java.util.Scanner;

public class FileManager {
	public Board readFile(int n) {
		Board result = null;

		try {
			Scanner sc = new Scanner(new File("./stages/stage_" + n + ".txt"));

			//System.out.println("getSize");
			Scanner size = new Scanner(sc.nextLine());
			int size_x = size.nextInt(), size_y = size.nextInt();
			//System.out.println("" + size_x + size_y);
			result = new Board(size_x, size_y);

			//System.out.println("getBeads");
			int beads = new Scanner(sc.nextLine()).nextInt();
			//System.out.println(beads);
			while(beads-- > 0) {
				Scanner beadInfo = new Scanner(sc.nextLine());
				int pos_x = beadInfo.nextInt(), pos_y = beadInfo.nextInt();
				int _r = beadInfo.nextInt(), _g = beadInfo.nextInt(), _b = beadInfo.nextInt();
				//System.out.println("" + pos_x + " " + pos_y + " " + _r + " " + _g + " " + _b);
				result.SetBeads(pos_x, pos_y, _r, _g, _b);
				//System.out.println(beads);
			}
			//System.out.println("set beads complete\nset rings");
			int rings = new Scanner(sc.nextLine()).nextInt();
			while(rings-- > 0) {
				Scanner ringInfo = new Scanner(sc.nextLine());
				int pos_x = ringInfo.nextInt(), pos_y = ringInfo.nextInt();
				int _color = ringInfo.nextInt();
				//System.out.println(pos_x + " " + pos_y + " " + _color);
				result.AddRing(pos_x, pos_y, _color);
			}

		} catch (Exception e) {
			System.out.println("Error!");
		}

	return result;
	}
}