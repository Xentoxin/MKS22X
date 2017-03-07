
public class LakeMake {
	private int[][] elevations;

	public LakeMake(int[][] e){
		elevations = e;
	}
public int returnStomps(int r, int c, int e){
	int temp = elevations[r][c];
	for(int i = 0 ; i < 3 ; i ++){
		for(int j = 0 ; j < 3 ; j++){
	if(elevations[r+i][c+j] > temp){
		temp = elevations[r+i][c+j];
	}
		}
	}
	return e - temp;
}
public static void main(String[] args){
	int[] a = {1,5,6};
	int[] b = {4,9,11};
	int[] c = {66, 17, 2};
	int[][] e = {a,b,c};
	LakeMake test= new LakeMake(e);
	System.out.println(Math.abs(test.returnStomps(0, 0, 1)));
}
}
