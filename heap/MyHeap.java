import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MyHeap<String extends Comparable<String>> {

	/* Leave this public!  We need it for testing */
	public ArrayList<String> data;
	private int size;


	private static int leftChildIndex(int currentIndex) {
		return 2 * currentIndex + 1;
	}

	private static int rightChildIndex(int currentIndex) {
		return 2 * currentIndex + 2;
	}

	private static int parentIndex(int currentIndex) {
		return (currentIndex - 1) / 2;
	}

	public MyHeap() { // constructor to construct an EMPTY arrayList for heap
		data = new ArrayList<String>();
	}


	public void add(T element) {

		data.add(element); // simply adding that anyType generic T to the list
		size++;
		int indexPosition = this.data.size() - 1; 


		while (indexPosition > 0 && element.compareTo(this.data.get((indexPosition -1)/2)) < 0) { 

			String hold = this.data.get((indexPosition -1) / 2);
			data.set(indexPosition, hold);
			indexPosition = (indexPosition - 1)/ 2;


		}

		this.data.set(indexPosition, element);
	}


	public String remove() {

		T newValue = this.data.remove(this.data.size()-1);
		int pos = 0;

		if (this.data.size() > 0) {
			while (2*pos+1 < this.data.size()) {
				int minChild = 2*pos+1;
				if (2*pos+2 < this.data.size() &&
						this.data.get(2*pos+2).compareTo(this.data.get(2*pos+1)) < 0) {
					minChild = 2*pos+2;
				}

				if (newValue.compareTo(this.data.get(minChild)) > 0) {
					this.data.set(pos, this.data.get(minChild));
					pos = minChild;
				}
				else {
					break;
				}
			}
			this.data.set(pos, newValue);
		}

		return newValue;

	}


	public boolean isEmpty() {
		return data.size() == 0;
	}


	public int getSize() {	
		return size;
	}
}