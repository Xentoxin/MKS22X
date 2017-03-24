
public class mergesort {
public static int[] mergesort(int[] ary){
	if(ary.length < 2){
		return ary;
	}
	int mid = ary.length / 2;
	int full = ary.length;
	int lefts = mid;
	int rights = full - mid;
	int[] left = new int[lefts];
	int[] right = new int[rights];
	for(int i = 0 ; i < mid ; i ++){
		left[i] = ary[i];
	}
	for(int i = mid ; i < full ; i++){
		right[ i - mid] = ary[i];
	}
	MergeSort(left);
	MergeSort(right);
	merge(left,right,ary);
	return ary;
}
public static int[] merge(int[] a, int[] b, int[] dest){
	int i = 0 , j = 0 , k = 0;
	while(i < a.length && j < b.length){
		if(a[i] <= b[j]){
			dest[k] = a[i];
			i++;
			k++;
		}
		else{
			dest[k] = b[j];
			j++;
			k++;
		}
	}
	while(i < a.length){
		dest[k] = a[i];
		i++;
		k++;
	}
	while(j < b.length){
		dest[k] = b[j];
		j++;
		k++;
	}
	return dest;
}
public static String toString(int[] ary){
	String str = "";
	for(int i = 0; i < ary.length ; i ++){
		str+= ary[i] + " ";
	}
	return str;
}
public static void main(String[] args){
	int[] test = {1,4,2,7,32,6,547,2,3,56,537};
	System.out.println(toString(MergeSort(test)));
}
}
