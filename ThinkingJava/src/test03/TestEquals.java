package test03;
/**
 * Test object isEqual
 * @author pineapple
 *
 */
public class TestEquals {

	public static void main(String[] args) {
		Value v1 = new Value();
		Value v2 = new Value();
		v1.i = v2.i = 100;
		System.out.println(v1.equals(v2));
		Integer i1 = new Integer(20);
		Integer i2 = new Integer(20);
		System.out.println(i1==i2);		
		System.out.println(i1.equals(i2));		
	}
}
class Value{
	int i;
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Value) {
			System.out.println(((Value)obj).i);
			return i == ((Value)obj).i;
		}
		return false;
	}
	
}