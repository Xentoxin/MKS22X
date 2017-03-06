import java.io.File;
import java.util.Scanner;

public class Maze {
	private char[][] maze;
	private boolean animate;

	public Maze(String filename) {
		input(filename);
		animate = false;
		boolean start = false, end = false;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j] == 'E') {
					end = true;
				}
				if (maze[i][j] == 'S') {
					start = true;
				}
			}
		}
		if (!(start && end)) {
			throw new IllegalArgumentException("Exception 1");
		}
	}

	public void input(String filename) {
		try {
			Scanner input = new Scanner(new File(filename));
			int count = 1;
			char[][] temp = new char[100][input.nextLine().length()];
			for (int i = 0; i < temp[0].length; i++) {
				temp[0][i] = '#';
			}
			while (input.hasNextLine()) {
				char[] arr = input.nextLine().toCharArray();
				temp[count] = arr;
				count++;
			}
			for (int i = 1; i < temp.length; i++) {
				if (!(temp[i][0] == ' ' || temp[i][0] == '#' || temp[i][0] == 'S' || temp[i][0] == 'E')) {
					maze = new char[i][temp[0].length];
					break;
				}
			}
			for (int i = 0; i < maze.length; i++) {
				maze[i] = temp[i];
			}
		} catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}
	}

	public boolean Solve() {
		int r = -1, c = -1;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j] == 'S') {
					r = i;
					c = j;
				}
			}
		}
		maze[r][c] = ' ';
		return helper(r, c);
	}

	public boolean helper(int r, int c) {
		if(animate){
			System.out.println("\033[2J\033[1;1H" + this);
			wait(60);
		}
		if (maze[r][c] == 'E') {
			return true;
		}
		if (maze[r][c] != ' ') {
			return false;
		}
		maze[r][c] = '@';
		if (!(helper(r + 1, c) || helper(r - 1, c) || helper(r, c + 1) || helper(r, c - 1))) {
			maze[r][c] = '*';
			if (maze[r + 1][c] == '@') {
				maze[r + 1][c] = ' ';
				return helper(r + 1, c);
			}
			else if (maze[r - 1][c] == '@') {
				maze[r - 1][c] = ' ';
				return helper(r - 1, c);
			}
			else if (maze[r][c + 1] == '@') {
				maze[r][c + 1] = ' ';
				return helper(r, c + 1);
			}
			else if (maze[r][c - 1] == '@') {
				maze[r][c - 1] = ' ';
				return helper(r, c - 1);
			}
			return false;
		}
		return true;
	}
private void wait(int millis){
	try{
		Thread.sleep(millis);
	}
	catch(InterruptedException e){}
}
	public void setAnimate(boolean b) {
		animate = b;
	}

	public void clearTerminal() {
		System.out.println("\033[2J\033[1;1H");
	}

	public String toString() {
		String str = "";
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				str += maze[i][j];
			}
			str += "\n";
		}
		return str;
	}
}
