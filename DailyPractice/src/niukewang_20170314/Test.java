package niukewang_20170314;

public class Test {
	Test t;
	public Test(Test t){
		System.out.println("b");
		this.t = t;
	}
	public Test() {
		System.out.println("a");
	}
	public static void main(String[] args) {
		Test test1 = new Test(new Test());
	}
}
