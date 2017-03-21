public class KnightBoard{
	private int[][] board;
	private int [] rInc = {1, 1, 2, 2, -1, -1, -2, -2};
	private int[] cInc = {2, -2, 1, -1, 2, -2, 1, -1};
	
	public KnightBoard(int r, int c){
		board = new int[r][c];
	}
	public void Solve(){
		helper(0,0,1);
	}
	public boolean helper(int r, int c , int level){
		if(level > board.length*board[0].length -1){
			return true;
		}
		if(r < 0 || c < 0 || r>=board.length || c >= board[0].length){
			return false;
		}
		if(board[r][c] == 0 ){
			board[r][c] = level;
			for(int i = 0 ; i < 8 ; i++){
				if(helper(r +rInc[i] , c + cInc[i] , level+1)){
					return true;
				}
			}
			board[r][c] = 0;
		}
		return false;
	}
	public String toString(){
		String s = "";
		if (!(board.length == 0 || board[0].length == 0) && board[0][0] != 0){
            for (int i = 0; i < board.length; i ++){
                for (int j = 0; j < board[0].length; j ++){
                    if (board[i][j] < 10){
                        s = s + "   " + board[i][j];
                    }
                    else if (board[i][j] < 100){
                        s = s + "  " + board[i][j];
                    }
                    else if (board[i][j] < 1000){
                        s = s + " " + board[i][j];
                    }
                    else{
                        s += board[i][j];
                    }
                    s += " ";
                }
                s += "\n";
            }
        }
		return s;
	}
	public static void main(String[] args){
		KnightBoard test = new KnightBoard(7,7);
		test.Solve();
		System.out.println(test.toString());
	}
}