package binarysearchtree;

public class Node {
	public int data;
	public Node left;
	public Node right;

	public Node(int data) {
		this.data = data;
	}

	public Node() {
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

}
