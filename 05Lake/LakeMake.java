import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LakeMake {
	private int[][] lake;

	public LakeMake(File filename) {
		fileReader(filename);

	}

	public void fileReader(File filename) {
		int R, C, E, N;
		try {
			Scanner sc = new Scanner(filename);
			R = Integer.parseInt(sc.next());
			C = Integer.parseInt(sc.next());
			E = Integer.parseInt(sc.next());
			N = Integer.parseInt(sc.next());
			lake = new int[R][C];
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					lake[i][j] = sc.nextInt();
				}
			}

		} catch (Exception e) {
			System.out.println("File not found");
		}
	}

	public int returnStomps(int r, int c, int e) {
		int temp = lake[r][c];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (lake[r + i][c + j] > temp) {
					temp = lake[r + i][c + j];
				}
			}
		}
		return e - temp;
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < lake.length; i++) {
			for (int j = 0; j < lake[0].length; j++) {
				str += lake[i][j];
			}
			str += "\n";
		}
		return str;
	}

	public static void main(String[] args) {/*
							 * int[] a = { 1, 5, 6 }; int[] b = { 4, 9, 11 };
							 * int[] c = { 66, 17, 2 }; int[][] e = { a, b, c };
							 * LakeMake test= new LakeMake(e);
							 * System.out.println(Math.abs(test.returnStomps(0,
							 * 0, 1)));
							 */
	}
}
