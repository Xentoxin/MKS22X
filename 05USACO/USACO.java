import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
public class USACO {
	//Bronze Lake Make
	public static int bronze(String filename){
		File input = new File(filename);
		Scanner sc;
		try{
			sc = new Scanner(input);
		}
		catch(FileNotFoundException e){
			System.out.println("FileNotFound");
			return -1;
		}
		int[] numbers = new int[4];
		numbers[0] = sc.nextInt(); // # of rows
		numbers[1] = sc.nextInt(); // # of cols
		numbers[2] = sc.nextInt(); // desired elevation
		numbers[3] = sc.nextInt(); //number of instructions
		int[][] lake = new int[numbers[0]][numbers[1]];
		for(int i = 0 ; i < numbers[0]; i ++){
			for (int j = 0 ; j < numbers[1] ; j++){
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
			temp  = Solver(instructions[i][0], instructions[i][1], instructions[i][2], lake);
			lake = temp.clone();
		}
		int depth = 0;
		for( int i = 0 ; i < numbers[0] ; i++){
			for(int j = 0; j < numbers[1] ; j++){
				if(numbers[2] - lake[i][j] > 0){
					depth += (numbers[2]-lake[i][j]);
				}
			}
		}
		return depth * 72 *72;
	}

	private static int[][] Solver(int startRow, int startCol, int decrement, int[][] board){
        int[] elevations = new int[9];
        int counter = 0;
        for(int i = startRow-1; i < startRow + 2; i++){
            for(int j = startCol-1; j < startCol + 2; j++){
                elevations[counter] = board[i][j];
                counter++;
            }
        }
        Arrays.sort(elevations);
        int highest = elevations[8];
        
        for(int i = startRow - 1; i < startRow + 2; i++){
            for(int j = startCol - 1; j < startCol + 2; j++){
                if(board[i][j] > highest - decrement){
                    board[i][j] = board[i][j] - (decrement - (highest - board[i][j]));
                }
            }
        }
        return board;
    }
	public static int silver(String filename){
		File input = new File(filename);
		Scanner sc;
		try{
			sc = new Scanner(input);
		}
		catch(FileNotFoundException e){
			System.out.println("FileNotFound");
			return -1;
		}
		int[] numbers = new int[4];
		numbers[0] = sc.nextInt(); // # of rows
		numbers[1] = sc.nextInt(); // # of cols
		numbers[2] = sc.nextInt(); // # of moves
		char[][] board = new char[numbers[0]][numbers[1]];
		for(int i = 0 ; i < numbers[0]; i ++){
				board[i] = sc.next().toCharArray();
		}
		int[] start = new int[2];
		int[] end = new int[2];
		start[0] = sc.nextInt();
		start[1] = sc.nextInt();
		end[0] = sc.nextInt();
		end[1] = sc.nextInt();
		int[][] board2 = new int[numbers[0]][numbers[1]];
		for(int i = 0 ; i < numbers[0]; i++){
			for(int j = 0 ; j < numbers[1] ; j++){
				if(board[i][j] == '*'){
					board2[i][j] =-1;
				}
				else{
					if(i == start[0] -1 && j == start[1]-1){
						board2[i][j] = 1;
					}
					else{
						board2[i][j] = 0;
					}
				}
			}
		}
		return Solver(start, end, board2, numbers[2]);
}
	public static int Solver(int[] start, int[] end, int[][] board, int moves){
		int[][] temp;
		for(int i = 0 ; i < moves; i++){
			temp = new int[board.length][board[0].length];
			for(int j = 0 ; j < board.length ; j ++){
				for(int k = 0 ; k < board[0].length; k++){
					if(valid(j,k,board)){
						temp[j][k] = sumNeighbors(j,k,board);
					}
					if(board[j][k] == -1){
						temp[j][k] = -1;
					}
					
				}
			}
			board= temp.clone();
		}
		return board[end[0] - 1][end[1] -1];
	}
	public static boolean valid(int x , int y, int[][] board){
		return !(x <0 || x >board.length|| y < 0 || y > board[0].length || board[x][y] == -1);
	}
	public static int sumNeighbors(int x, int y, int[][] board){
		int sum = 0;
		if(valid(x+1,y,board)){
			sum+= board[x+1][y];
		}
		if(valid(x-1 , y, board)){
			sum+= board[x-1][y];
		}
		if(valid(x, y+1, board)){
			sum+= board[x][y+1];
		}
		if(valid(x, y-1, board)){
			sum+= board[x][y-1];
		}
		return sum;
	}
}
