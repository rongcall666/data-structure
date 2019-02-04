package hafuman;

public class HaffmanNode {
	int val; //ֵ
	int weight;//Ȩֵ
	char ch;//�����ַ���
	HaffmanNode left;//����
	HaffmanNode right;//�Һ���
	public HaffmanNode(int val, char ch) {
		this.val = val;
		this.ch = ch;
	}
	@Override
	public String toString() {
		return "HaffmanNode [val=" + val + ", weight=" + weight + ", ch=" + ch + ", left=" + left + ", right=" + right
				+ "]";
	}
}
