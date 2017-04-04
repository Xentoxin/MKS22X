public class MyLinkedList {
	private LNode start;
	private int size;

	public static void main(String[] args) {
		MyLinkedList m = new MyLinkedList();
		m.add(1);
		m.add(2);
		m.add(3);

		System.out.println(m.toString());
	}

	public MyLinkedList() {
		start = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public void add(int v) {
		if(size == 0){
			start = new LNode(v);
			size++;
		}
		LNode x = start;
		while(x.next != null){
			x = x.next;
		}
		x.next = new LNode(v);
		size++;
	}

	public void add(int v, int pos) {
		if (pos > size) {
			throw new IndexOutOfBoundsException();
		}
		int counter = 0;
		LNode x = start;
		while (counter < pos) {
			x = x.next;
			counter++;
		}
		x = new LNode(v, x);
		counter = 0;
		LNode y = start;
		while (counter < pos - 1) {
			y = y.next;
			counter++;
		}
		y.next = x;
		size++;
	}

	public int get(int index) {
		if(index >= size) {
			throw new IndexOutOfBoundsException();
		}
		int counter = 0;
		LNode x = start;
		while(counter < index) {
			x = x.getNext();
			counter ++;
		}
		return x.value;
	}
	public void set(int index , int v){
		if(index >= size){
			throw new IndexOutOfBoundsException();
		}
		int counter = 0;
		LNode x = start;
		while(counter < index){
			x = x.next;
			counter++;
		}
		x.value = v;
	}
	public int indexOf(int v){
		int counter = 0;
		LNode x = start;
		while(x.value != v){
			if(x.next == null){
				return -1;
			}
			x = x.next;
			counter++;
		}
		return counter;
	}
	public int remove(int index){
		if(index >= size){
			throw new IndexOutOfBoundsException();
		}
		int counter = 0 ;
		LNode x = start; 
		while(counter < index - 1){
			x = x.next;
			counter++;
		}
		LNode y = x.next.next;
		x.next = y;
		size--;
		return index;
	}

	public String toString() {
		String str = "[ ";
		LNode x = start;
		for (int i = 0; i < size; i++) {
			str += x.value + " ";
			x = x.next;
		}
		return str.substring(0,str.length()-1) + "]";
	}

	private class LNode {
		private int value;
		private LNode next;

		public LNode() {
			next = null;
			value = 0;
		}

		public LNode(int v) {
			value = v;
			next = null;
		}

		public LNode(int v, LNode n) {
			value = v;
			next = n;
		}

		public void setNext(LNode n) {
			next = n;
		}

		public LNode getNext() {
			return next;
		}

		public int getValue() {
			return value;
		}
	}
}
