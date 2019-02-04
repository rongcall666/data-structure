package list;

public class MyLinkedList {

	private Node head;

	public void replase() {
		Node flag = head;
		Node prev = null;
		while (flag != null) {
			System.out.println(flag.object);
			Node next = flag.next;

			flag.next = prev;

			prev = flag;

			flag = next;
		}
		head = prev;
	}

	public void add(Object object) {
		if (head == null) {
			head = new Node(object);
		} else {
			Node flag = head;
			for (; flag.next != null; flag = flag.next) {
			}
			flag.next = new Node(object);
		}
	}

	public void print() {
		for (Node flag = head; flag != null; flag = flag.next) {
			System.out.println(flag.object);
		}
	}

	public Integer length() {
		int length = 0;
		for (Node flag = head; flag != null; flag = flag.next, length++) {
		}
		return length;
	}

	public void remove() {
		Node flag = head;
		for (; flag.next.next != null; flag = flag.next) {
		}
		flag.next = null;
	}

	public Object get(int index) {
		int i = 0;
		if (head == null) {
			return null;
		}
		Object obj = null;
		for (Node flag = head; flag != null; flag = flag.next, i++) {
			if (i == index - 1) {
				obj = flag.object;
				break;
			}
		}
		return obj;
	}

}

class Node {
	public Object object;
	public Node next;

	public Node(Object object) {
		this.object = object;
	}
}
