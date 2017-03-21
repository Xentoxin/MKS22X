import java.util.Random;

public class part {
	public static void main(String[] args) {
		int[] ary = { 99, 999, 99999, 1, 3, 0, 6, 2, 9995, 99999 };
		QuickSort(ary);
		System.out.println(toString(ary));
	}

	public static int partition(int[] ary, int start, int end) {
		Random rand = new Random();
		int r = rand.nextInt((end - start) + start);
		if (r == end) {
			r--;
		}
		int comp = ary[r];
		int s = start;
		int e = end - 1;
		int temp = ary[end];
		ary[end] = comp;
		ary[r] = temp;
		while (s != e && e!= s - 1 && e != s+1) {
			if (ary[s] > comp && ary[e] < comp) {
				temp = ary[e];
				ary[e] = ary[s];
				ary[s] = temp;
				e--;
				s++;
			}
			else if(ary[s] > comp)  e--;
			else if(ary[e] < comp) s++;
			else{
				e--;
				s++;
			}
		}
		if(e != s){
			if(ary[s] > ary[e]){
				temp = ary[e];
				ary[e] = ary[s];
				ary[s] = temp;
			}
		}
		while(ary[s] < comp){
			s++;
		}
		temp = ary[s];
		ary[s] = comp;
		ary[end] = temp;
		return s;
	}
	public static int quickSelect(int[] data, int x){
		return selectHelper(data, x, 0 , data.length-1);
	}
	public static int selectHelper(int[] data, int x, int start, int end){
		if(end == start) return data[end];
		int pivot = partition(data, start, end);
		if(pivot == x) return data[pivot];
		else if(pivot > x) return selectHelper(data, x, 0 , pivot-1);
		else return selectHelper(data, x, pivot +1 , data.length -1);
	}
public static void QuickSort(int[] data){
	quickHelper(data , 0 , data.length -1);
			}
public static void quickHelper(int[] data , int start, int end){
	if(start < end){
		int pivot = partition(data, start, end);
		quickHelper(data, start, pivot-1);
		quickHelper(data, pivot +1 , end);
		
	}
}
public static String toString(int[] ary){
	String s = "[";
	for(int i = 0 ; i < ary.length; i++){
		s =s + " " + ary[i];
	}
	return s + "]";
}
}

