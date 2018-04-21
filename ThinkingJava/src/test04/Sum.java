package test04;

public class Sum {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 101; i++) {
			sum += i;
		}
		System.out.println("常规sum:" + sum);
		System.out.println("递归sum:" + sum(100));
	}

	public static int sum(int i) {

		if (i < 1) {
			return 0;
		}
		return i + sum(i - 1);
	}
}
