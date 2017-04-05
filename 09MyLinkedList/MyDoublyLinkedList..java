vpublic class MyLinkedList {
	private LNode start, end;
	private int size;

	public static void main(String[] args) {
		MyLinkedList m = new MyLinkedList();
		m.add(1);
		m.add(2);
		m.add(3);
		m.add(4);
		m.add(5);
		m.add(6);
		m.add(7);
		System.out.println(m.toString());
	}

	public MyLinkedList() {
		start = null;
		end = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public LNode getNthNode(int n) {
		if (n >= size) {
			throw new IndexOutOfBoundsException();
		}
		LNode x = new LNode();

		if (n > size / 2) {
			int counter = size - n;
			x = end;
			while (counter > 0) {
				counter--;
				x = x.prev;
			}
		} else {
			int counter = n;
			x = start;
			while (counter > 0) {
				counter--;
				x = x.next;
			}
		}

		return x;
	}
	public void remove(LNode target){
		target.prev.next = target.next;
		target.next.prev = target.prev;
		size--;
	}

	public void add(int v) {
		if (size == 0) {
			start = new LNode(v);
			size++;
		}
		LNode x = start;
		while (x.next != null) {
			x = x.next;
		}
		x.next = new LNode(v);
		size++;
	}

	/*
	 * public void add(int v, int pos) { if (pos > size) { throw new
	 * IndexOutOfBoundsException(); } int counter = 0; LNode x = start; while
	 * (counter < pos) { x = x.next; counter++; } x = new LNode(v, x); counter =
	 * 0; LNode y = start; while (counter < pos - 1) { y = y.next; counter++; }
	 * y.next = x; size++; }
	 */
	public int get(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		int counter = 0;
		LNode x = start;
		while (counter < index) {
			x = x.getNext();
			counter++;
		}
		return x.value;
	}

	public void set(int index, int v) {
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		int counter = 0;
		LNode x = start;
		while (counter < index) {
			x = x.next;
			counter++;
		}
		x.value = v;
	}

	public int indexOf(int v) {
		int counter = 0;
		LNode x = start;
		while (x.value != v) {
			if (x.next == null) {
				return -1;
			}
			x = x.next;
			counter++;
		}
		return counter;
	}

	public int remove(int index) {
		if (index >= size) {
			throw new IndexOutOfBoundsException();
		}
		int counter = 0;
		LNode x = start;
		while (counter < index - 1) {
			x = x.next;
			counter++;
		}
		LNode y = x.next.next;
		x.next = y;
		size--;
		return index;
	}

	public String toString() {
		String str = "";
		LNode x = start;
		for (int i = 0; i < size; i++) {
			str += x.value + " ";
			x = x.next;
		}
		return "[" + str.substring(1, str.length() - 1) + "]";
	}

	private class LNode {
		private int value;
		private LNode next, prev;

		public LNode() {
			next = null;
			prev = null;
			value = 0;
		}

		public LNode(int v) {
			value = v;
			next = null;
			prev = null;
		}

		public LNode(int v, LNode n, LNode p) {
			value = v;
			next = n;
			prev = p;
		}

		public void setNext(LNode n) {
			next = n;
		}

		public LNode getNext() {
			return next;
		}

		public void setPrev(LNode p) {
			prev = p;
		}

		public LNode getPrev() {
			return prev;
		}

		public int getValue() {
			return value;
		}
	}
}
