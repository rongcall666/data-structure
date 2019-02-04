package list;

public class MyLinearList {
	private Object[] object;

	private Integer size;

	public MyLinearList() {
		this.object = new Object[10];
//		size = 0;
	}

	public MyLinearList(int length) {
		this.object = new Object[length];
		size = 0;
	}

	public void add(Object value) {
		if (size >= this.object.length) {
			kuorong();
		}
		this.object[size++] = value;
	}

	public void remove() {
		this.object[size--] = null;
	}

	public Object get(int index) {
		return this.object[index - 1];
	}

	public Integer length() {
		return this.size;
	}

	public int indexOf(Object value) {
		for (int i = 0; i < this.size; i++) {
			if (this.object[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}

	private void kuorong() {
		System.out.println("����");
		Object newObject[] = new Object[2 * this.object.length];
		int i = 0;
		for (Object obj : this.object) {
			newObject[i++] = obj;
		}
		this.object = newObject;
	}
}
