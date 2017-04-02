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
		LNode x = new LNode(v);
		LNode y = start;
		if (start == null) {
			start = x;
		} else {
			while (y.getNext() != null) {
				y.next = y.getNext();
			}
			y.setNext(x);
		}
		size++;
	}

	public void add(int v, int pos) {
		LNode x = new LNode(v);
		LNode y = start;
		if (pos == 0) {
			x.setNext(start);
			start = x;
		} else {
			for (int i = 0; i < pos; i++) {
				y = y.getNext();
			}
			x.setNext(y.getNext());
			y.setNext(x);
		}
		size++;
	}
	public int get(int index) {
		LNode x = start;
		for (int i = 0; i < index; i++) {
			x = x.getNext();
		}
		return x.getValue();
	}

	public String toString() {
		String str = "[ " + start.getValue() + " ";
		LNode x = start;
		while(x.getNext() != null){
			x = x.getNext();
			str += x.getValue() + " ";
		}
		return str + "]";
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
