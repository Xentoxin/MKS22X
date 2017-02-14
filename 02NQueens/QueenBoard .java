

public class QueenBoard {
private int[][] board;
private int solutionCount;
public static void main(String[] args){
	int n = 10;
	QueenBoard test = new QueenBoard (n);
	test.Solver();
	System.out.println(test.Debug());
	System.out.println(test.toString());
	QueenBoard  test2 = new QueenBoard (n);
	test2.countSolutions();
	System.out.println(test2.getSolutionCount());
}
public QueenBoard (int n){
	board = new int[n][n];
	solutionCount = -1;
}

public void Solver(){
	helper(0);
}

public boolean helper(int n){
	if(n >= board.length){
		return true;
	}
	int count = -1;
	for(int r = 0 ; r <board.length ; r++){
		if(board[r][n]  <0 ){
			count = removeQueen(r,n);
			break;
		}
		else
			if(board[r][n] == 0){
				count = r;
				break;
			}
	}
		if(count >= 0){
			addQueen(count,n);
			return helper(n+1);
		}
		if(n ==0){
			return false;
		}
		return helper(n-1);
}
public void addQueen(int r, int c){
	for(int i = 0 ; i <board.length ; i++){
		board[i][c]++;
		board[r][i]++;
	}
	int count = 0 ;
	while(r - count >= 0 && c- count >= 0){
		board[r-count][c-count] ++;
		count++;
	}
	count = 0 ;
	while(r+count <board.length && c+count < board.length){
		board[r+count][c+count]++;
		count++;
	}
	count = 0;
	while(r-count >= 0 && c+count < board.length){
		board[r-count][c+count]++;
		count++;}
	count = 0;
	while(r+count <board.length && c -count >= 0){
		board[r+count][c-count]++;
		count++;
	}
	board[r][c] = -1;
}
public int removeQueen(int r, int c){
	for(int i = 0 ; i <board.length ; i++){
		board[i][c]--;
		board[r][i]--;
	}
	int count = 0 ;
	while(r - count >= 0 && c- count >= 0){
		board[r-count][c-count] --;
		count++;
	}
	count = 0 ;
	while(r+count <board.length && c+count < board.length){
		board[r+count][c+count]--;
		count++;
	}
	count = 0;
	while(r-count >=0 && c+count <board.length){
		board[r-count][c+count]--;
		count++;}
	count = 0;
	while(r+count <board.length && c -count >=0){
		board[r+count][c-count]--;
		count++;
	}
	board[r][c] =0;
	int k = -1;
	for(int i = 0 ; i <board.length ; i++){
		if(board[i][c] == 0 && i >r){
			k = i;
			break;
		}
	}
	return k;
}

public int getSolutionCount(){
	return solutionCount;
}

public void countSolutions(){
	if(board.length == 2 || board.length==3){
		solutionCount = 0;
	}
	else{
		Solver();
		solutionCount++;
		boolean lmao = true;
		while(lmao){
			lmao = helper(board.length-1);
			solutionCount++;
		}
	}
}


public String toString(){
	String str = "";
    for (int i = 0; i < board.length; i ++){
        for (int j = 0; j < board.length; j ++){
            if (board[i][j] == -1){
                str += "Q ";
            }
            else{
                str+= "_ ";
            }
        }
        str += "\n";
    }
    return str;
}

public String Debug(){
    String str = "";
    for (int i = 0; i < board.length; i ++){
        for (int j = 0; j < board.length; j ++){
            str+= board[i][j] + " ";
        }
        str += "\n";
    }
    return str;
}
}
