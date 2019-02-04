package hafuman;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Haffman {
	HaffmanNode root;
	int count[] = new int[35];// ͳ���ַ����ֵĴ���������ֻ�ռ� A~Z��

	public void build(char[] arr) {
		// ��ͳ���ַ������е��ַ����ֵĴ���
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - 'A']++;
		}
		// �������ȶ��У�Ĭ�������ȼ���ģ��ȳ����У����ȼ�һ�����ն��е��Ƚ��ȳ�
		// ���չ�����������С�������ڵ��ȳ��������޸ıȽ�����
		PriorityQueue<HaffmanNode> priorityQueue = new PriorityQueue<>(new Comparator<HaffmanNode>() {
			public int compare(HaffmanNode o1, HaffmanNode o2) {
				return o1.val - o2.val;
			}
		});
		// �½��ַ��ڵ㣬���ҽ��ڵ㰴�ճ��ִ�����Ϊ���ȼ��������ȶ�����
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				priorityQueue.offer(new HaffmanNode(count[i], (char) (65 + i)));
			}
		}
		// �����ȶ����еĽڵ�������1ʱ��
		while (priorityQueue.size() != 1) {
			// ȡ��������С���Լ��ڶ�С�Ľڵ�
			HaffmanNode left = priorityQueue.poll();
			HaffmanNode right = priorityQueue.poll();
			// ����һ���µĽڵ㣬�������ȶ����У�ֵΪ���Ӽ��Һ��ӵ�ֵ
			HaffmanNode newHaffmanNode = new HaffmanNode(left.val + right.val, ' ');
			newHaffmanNode.left = left;
			newHaffmanNode.right = right;
			priorityQueue.add(newHaffmanNode);
		}
		// �����ȶ�����ֻʣһ��ʱ����ʱ�Ľڵ�����Ѿ������õĹ�������
		root = priorityQueue.poll();
	}

	// map�洢�ַ����ֵ�Ȩֵ
	private Map<Character, Integer> map1 = null;

	private void getWeight() {
		// ����Ȩֵ
		map1 = new HashMap<>();
		count(root, 0);
	}

	// ��ȡȨֵ
	public Integer getWeight(char ch) {
		if (map1 == null) {
			getWeight();
		}
		return map1.get(ch);
	}

	public void count(HaffmanNode haffmanNode, int weight) {
		// �ݹ����Ȩֵ
		if (haffmanNode != null && haffmanNode.ch != ' ') {
			map1.put(haffmanNode.ch, weight);
		}
		if (haffmanNode.left != null) {
			count(haffmanNode.left, weight + 1);
		}
		if (haffmanNode.right != null) {
			count(haffmanNode.right, weight + 1);
		}
	}

	// �洢һ���ַ��Ĺ����������ı��뼯
	private Map<Character, String> map = new HashMap<>();

	public void bianmaShow() {
		for (Entry<Character, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	public void bianma() {
		bianma(root, "");
	}

	private void bianma(HaffmanNode node, String str) {
		if (node.ch >= 'A' && node.ch <= 'Z') {
			// ��¼�ַ��Ĺ���������
			map.put(node.ch, str);
		}
		if (node.left != null) {
			// ������ߣ�����Ϊ0
			bianma(node.left, str + "0");
		}
		if (node.right != null) {
			// ���Ҳ��ߣ�����Ϊ1
			bianma(node.right, str + "1");
		}
	}

	public void show() {
		show(root);
	}

	public void show(HaffmanNode haffmanNode) {
		System.out.println(haffmanNode);
		if (haffmanNode.left != null)
			show(haffmanNode.left);
		if (haffmanNode.right != null)
			show(haffmanNode.right);
	}
	public void showss() {
		System.out.println(root);
	}

}
