package stack;

public class MyStack {
	private Object[] object;

	private Integer size;

	public MyStack() {
		this.object = new Object[10];
		size = 0;
	}

	public MyStack(int length) {
		this.object = new Object[length];
		size = 0;
	}

	public void push(Object value) {
		if (size >= this.object.length) {
			kuorong();
		}
		this.object[size++] = value;
	}

	public Object peek() {
		return this.object[size];
	}

	public Object pop() {
		Object obj = this.object[--size];
		this.object[size] = null;
		return obj;
	}

	public Integer length() {
		return this.size;
	}

	private void kuorong() {
		System.out.println("À©ÈÝ");
		Object newObject[] = new Object[2 * this.object.length];
		int i = 0;
		for (Object obj : this.object) {
			newObject[i++] = obj;
		}
		this.object = newObject;
	}

}
