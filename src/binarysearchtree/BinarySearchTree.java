package binarysearchtree;

public class BinarySearchTree {

	private Node root;

	public void add(int val) {
		if (root == null) {
			//����Ϊ��ʱ���½�һ�����ڵ�
			root = new Node(val);
		} else {
			//������Ϊ��ʱ
			Node next = root;
			//���б�����������������ǰֵ���Ǹ�λ��
			while (next != null) {
				if (val > next.data) {
					//���next���Һ��ӽڵ�Ϊ�գ���ô����һ���ڵ���Ϊnext���Һ��ӽڵ�
					//��Ϊ�����������
					if (next.right == null) {
						next.right = new Node(val);
						break;
					} else {
						next = next.right;
					}
				} else {
					if (next.left == null) {
						next.left = new Node(val);
						break;
					} else {
						next = next.left;
					}
				}

			}
		}
	}

	public void show() {
		show(root);
	}

	private void show(Node next) {
		if (next.left != null) {
			show(next.left);
		}
		System.out.print(next.data + " ");
		if (next.right != null) {
			show(next.right);
		}
	}

	public boolean index(int val) {
		if (root == null) {
			return false;
		} else {
			Node next = root;
			while (next != null) {
				if (next.data == val) {
					return true;
				} else if (next.data > val) {
					if (next.right == null) {
						return false;
					}
					next = next.right;
				} else {
					if (next.left == null) {
						return false;
					}
					next = next.left;
				}
			}
			return false;
		}
	}

	public Integer delete(int val) {
		if (root == null) {
			return -1;
		} else {
			Node next = root;
			Node parent = null;
			while (next != null) {
				if (next.data > val) {
					if (next.left != null) {
						parent = next;
						next = next.left;
					} else {
						//û�ҵ���ɾ����ֵ
						return -1;
					}
				} else if (next.data == val) {
					//û�к��ӽڵ㣬��ɾ���Ľڵ�ĸ��ڵ�ֱ��ɾ���ýڵ�
					if (next.left == null && next.right == null) {
						if (next.data > parent.data) {
							parent.right = null;
						} else {
							parent.left = null;
						}
					}
					//��һ���ڵ㣬���滻
					else if (next.left == null && next.right != null) {
						if (next.data > parent.data) {
							parent.right = next.right;
						} else {
							parent.left = next.right;
						}
					} else if (next.left != null && next.right == null) {
						if (next.data > parent.data) {
							parent.right = next.left;
						} else {
							parent.left = next.left;
						}
					} else {
						//�ҵ�����������С�Ľڵ�
						Node temp = next.right;
						Node tparent = next;
						if (temp.left != null) {
							while (temp.left != null) {
								tparent = temp;
								temp = temp.left;
							}
							tparent.left = null;
						}
						//�ýڵ㱣����������С�Ľڵ���Һ���
						Node houxu = null;
						if (temp.right != null) {
							houxu = temp.right;
							temp.right = null;
						}
						//��ɾ���ڵ������
						Node nextleft = null;
						if (next.left != null) {
							nextleft = next.left;
						}
						//��ɾ���ڵ���Һ���
						Node nextright = null;
						if (next.right != null) {
							nextright = next.right;
						}
						//��ɾ���ڵ�ĸ��ڵ㣬�滻��ɾ���Ľڵ�
						if (parent != null) {
							if (next.data > parent.data) {
								parent.right = temp;
							} else {
								parent.left = temp;
							}
						} else {
							root = temp;
						}
						//��������С�Ľڵ���Һ��ӣ���Ϊ��������С�Ľڵ�ĵĸ��׽ڵ������
						if (houxu != null) {
							tparent.left = houxu;
						}
						//�ж��ǲ�������������СֵΪ ��ɾ���ڵ���Һ��ӣ����򲻽���ɾ���ڵ���Һ�����Ϊ����ڵ���Һ��ӣ���Ȼ�γ��˱ջ�
						if (nextright != null && next.right.data != temp.data) {
							temp.right = nextright;
						} else {
							temp.right = houxu;
						}
						//��ɾ���ڵ��������Ϊ����ڵ������
						if (nextleft != null) {
							temp.left = nextleft;
						}

					}
					return val;
				} else {
					if (next.right != null) {
						parent = next;
						next = next.right;
					} else {
						return -1;
					}
				}

			}
		}
		return -1;
	}

	public Integer max() {
		if (root == null) {
			return null;
		} else {
			Node next = root;
			while (next.right != null) {
				next = next.right;
			}
			return next.data;
		}
	}

	public Integer min() {
		if (root == null) {
			return null;
		} else {
			Node next = root;
			while (next.left != null) {
				next = next.left;
			}
			return next.data;
		}
	}
}
