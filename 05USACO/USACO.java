import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class USACO {
	//Bronze Lake Make
	public static int bronze(String filename){
		File input = new File(filename);
		Scanner sc;
		try{
			sc = new Scanner(input);
		}
		catch(Exception e){
			System.out.println("Error 1");
			return -1;
		}
		int[] numbers = new int[4];
		numbers[0] = sc.nextInt(); // # of rows
		numbers[1] = sc.nextInt(); // # of cols
		numbers[2] = sc.nextInt(); // desired elevation
		numbers[3] = sc.nextInt(); //number of instructions
		int[][] lake = new int[numbers[0]][numbers[1]];
		for(int i = 0 ; i < lake.length; i ++){
			for (int j = 0 ; j < lake[0].length ; j++){
				lake[i][j] = sc.nextInt();
			}
		}
		//instructions
		int[][] instructions = new int[numbers[3]][3];
		for(int i = 0 ; i < numbers[3] ; i ++){
			for(int j = 0 ; j < 3 ; j++){
				instructions[i][j] = sc.nextInt();
			}
		}
		for(int i = 0 ; i < instructions.length ; i ++){
			int[][] temp = new int[numbers[0]][numbers[1]];
			temp  = lakeMaker(instructions[i][0], instructions[i][1], instructions[i][3], lake);
			lake = temp;
		}
		int depth = 0;
		for( int i = 0 ; i < numbers[0] ; i++){
			for(int j = 0; j < numbers[1] ; j++){
				if(numbers[2] - lake[i][j] > 0){
					depth += numbers[2]-lake[i][j];
				}
			}
		}
		return depth * 72 *72;
	}

	private static int[][] lakeMaker(int r, int c , int decrement, int[][] lake) {
		int[] elevations = new int[9];
		int counter = 0;
		for(int i = r -1 ; i < r+ 2 ; i ++){
			for(int j = c -1; i <c+2 ; j++){
				elevations[counter] = lake[i][j];
				counter++;
			}
		}
		Arrays.sort(elevations);
		int highest = elevations[8];
		for(int i = r -1; i < r+2 ; i++){
			for(int j = c-1 ; j < c+2 ; j++){
				if(lake[i][j] > highest - decrement){
					lake[i][j] = lake[i][j] - (decrement - (highest - lake[i][j]));
				}
			}
		}
		return lake;
	}
	//Silver C-Travel not done yet
	public static int silver(String filename){
		return -1;
	}
}
