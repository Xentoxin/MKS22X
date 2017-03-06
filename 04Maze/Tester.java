
public class Tester {
	public static void main(String[] args) {
		Maze f = new Maze("data3.dat");
		f.setAnimate(true);
		System.out.println(f.Solve());
		System.out.println(f.toString());
	}
}
