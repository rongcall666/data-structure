package unionfind;

public class UnionFind {

	private int value[];

	public void init(int n) {
		value = new int[n];
		for (int i = 0; i < n; i++) {
			value[i] = i;
		}
	}

	public void union(int x, int y) {
		int xV = value[x];
		int yV = value[y];
		if (xV != yV) {
			for (int i = 0; i < value.length; i++) {
				if (value[i] == xV) {
					value[i] = yV;
				}
			}
		}
	}

	public void union2(int x, int y) {
		int xV = value[x];
		int yV = value[y];
		if (xV != yV) {
			value[x] = value[y];
		}
	}

	public void union3(int x, int y) {
		int pre = find2(y);
		if(value[x] != pre) {
			value[x] = pre;
		}
	}

	public int find2(int x) {
		if (value[x] == x) {
			return value[x];
		}
		return find2(value[x]);
	}

	public int find(int x) {
		return value[x];
	}

	public boolean isConnected(int x, int y) {
		return value[x] == value[y];
	}

}
