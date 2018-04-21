
public class TestConstructor {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(new B().getI());
		}
	}

}

class AA {
	private static int i = 0;

	AA(int i) {
		AA.i++;
	}

	public int getI() {
		return i;
	}
}

class B extends AA {
	B() {
		super(1);
	}
}