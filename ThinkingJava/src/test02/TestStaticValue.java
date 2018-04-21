package test02;
/**
 * 测试静态属性
 * @author pineapple
 *
 */
public class TestStaticValue {
	
	static int i = 5;
	int n = 3;
	public static void main(String[] args) {
		TestStaticValue i1 = new TestStaticValue();
		System.out.println("i1.i: "+i1.i+"--"+"i1.n: "+i1.n);
		TestStaticValue i2 = new TestStaticValue();
		i1.i = 6;
		i1.n = 4;
		System.out.println("i1.i=:"+i1.i);
		System.out.println("i1.n=:"+i1.n);
		System.out.println("i2.i=:"+i2.i);
		System.out.println("i2.n=:"+i2.n);
	}
	
}
