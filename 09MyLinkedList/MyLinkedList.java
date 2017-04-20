import java.util.*;

public class MyLinkedList implements Iterable<Integer> {

	LNode start, end;
	int size;

	public MyLinkedList() {
	}

	public Iterator<Integer> iterator() {
		return new MyLinkedListIterator(this);
	}

	public int size() {
		return size;
	}

	private LNode getNthNode(int index) {
		if (index > size)
			throw new IndexOutOfBoundsException();
		LNode x;
		if (index > size / 2) {
			int counter = size - index;
			x = end;
			while (counter > 1) {
				counter--;
				x = x.prev;
			}
		} else {
			int counter = index;
			current = start;
			while (counter > 0) {
				counter--;
				current = current.next;
			}
		}
		return current;
	}

	public String toString() {
		String s = "[";
		LNode current = start;
		for (int i = 0; i < size; i++) {
			s += current.value + " ";
			current = current.next;

		}
		if (size == 0) {
			return s + "]";
		}
		return s.substring(0, s.length() - 1) + "]";
	}

	public boolean add(int value) {
		if (size == 0) {
			start = new LNode(value);
		} else if (size == 1) {
			end = new LNode(value);
			end.prev = start;
			start.next = end;
		} else {
			end = new LNode(value, end);
			end.prev.next = end;
		}
		size++;
		return true;
	}

	public int get(int index) {
		LNode n = getNthNode(index);
		if (index == size)
			throw new IndexOutOfBoundsException();
		return n.value;
	}

	public int set(int index, int value) {
		LNode n = getNthNode(index);
		if (index == size)
			throw new IndexOutOfBoundsException();
		int v = n.value;
		n.value = value;
		return v;
	}

	public int indexOf(int value) {
		int counter = 0;
		LNode current = start;
		while (current != null && current.value != value) {
			counter++;
			current = current.next;
		}
		if (counter == size)
			return -1;
		return counter;
	}

	public int remove(int index) {
		LNode n = getNthNode(index);
		if (index == size)
			throw new IndexOutOfBoundsException();
		if (size == 1) {
			start = null;
			size--;
			return n.value;
		}
		if (index == 0) {
			n.next.prev = null;
			start = n.next;
		} else if (index == size - 1) {
			n.prev.next = null;
			end = n.prev;
		} else {
			n.prev.next = n.next;
			n.next.prev = n.prev;
		}
		size--;
		return n.value;
	}

	public void add(int index, int value) {
		LNode n = getNthNode(index);
		size++;
		LNode p = new LNode(value);
		if (index == 0) {
			start = p;
			p.next = n;
			n.prev = p;
		} else if (index == size - 1) {
			end = p;
			p.prev = n;
			n.next = p;
		} else {
			p.prev = n.prev;
			p.next = n;
			n.prev.next = p;
			n.prev = p;
		}
	}

	public static class MyLinkedListIterator implements Iterator<Integer> {

		private int index;
		private MyLinkedList m;

		public MyLinkedListIterator(MyLinkedList list) {
			index = 0;
			m = list;
		}

		public boolean hasNext() {
			return index < m.size();
		}

		public Integer next() {
			int returned = m.get(index);
			index++;
			return returned;
		}

	}

	private class LNode {

		LNode next, prev;
		int value;

		private LNode(int v) {
			value = v;
		}

		private LNode(int v, LNode n) {
			value = v;
			prev = n;
		}

		public String toString() {
			if (prev == null && next == null) {
				return "null " + value + " null";
			} else {
				if (prev == null) {
					return "null " + value + " " + next.value;
				} else {
					if (next == null) {
						return prev.value + " " + value + " null";
					}
				}
			}
			return prev.value + " " + value + " " + next.value;
		}

	}
}