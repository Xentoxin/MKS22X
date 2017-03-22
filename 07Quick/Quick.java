import java.util.Random;

public class Quick {
	public static void main(String[] args) {
		int[] ary = {6,5,3,1,4, 2,0 };
		partition(ary, 0 ,6);
		System.out.println(toString(ary));
System.out.println(quickselect(ary, 5));
		quicksort(ary);
		System.out.println(toString(ary));
		
	}

	public static int partition(int[] ary, int start, int end) {
		Random rand = new Random();
		int r = rand.nextInt(end - start) + start;
		if (r == end) {
			r--;
		}
		int comp = ary[r];
		int s = start;
		int e = end - 1;
		swap(ary, end, r);
		while (s <= e) {
			if (ary[s] < comp) {
				s++;
			}
			else{
				swap(ary, s, e);
				e--;
			}
	}
		swap(ary, s, end);
		return s;
	}
	public static int quickselect(int[] data, int x){
		return selectHelper(data, x, 0 , data.length-1);
	}
	public static int selectHelper(int[] data, int x, int start, int end){
		if(end <= start) return data[end];
		int pivot = partition(data, start, end);
		if(pivot == x) return data[pivot];
		else if(pivot > x) return selectHelper(data, x, 0 , pivot-1);
		else return selectHelper(data, x, pivot +1 , data.length -1);
	}
	
public static void quicksort(int[] data){
	quickHelper(data , 0 , data.length -1);
			}
public static void quickHelper(int[] data , int start, int end){
	if(start < end){
		int pivot = partition(data, start, end);
		quickHelper(data, start, pivot-1);
		quickHelper(data, pivot +1 , end);
		
	}
}
public static void swap(int[] ary, int x, int y){
	int temp = ary[x];
	ary[x] = ary[y];
	ary[y] = temp;
}
public static String toString(int[] ary){
	String s = "[";
	for(int i = 0 ; i < ary.length; i++){
		s =s + " " + ary[i];
	}
	return s + "]";
}
}

