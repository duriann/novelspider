package test05;

public class TestArrayAndCanChangeArgs {

	TestArrayAndCanChangeArgs(String s){
		System.out.println(s);
	}
	public static void testCanChangeArgs(String[]s,String...args){	
		for (String s1 : s) {
			System.out.println(s1);
		}
		for (String string : args) {
			System.out.println(string);
		}
	}
	public static void main(String[] args,String...a) {
		//TestArray[] testArrays = new TestArray[]{ new TestArray("1"),new TestArray("2")};
		TestArrayAndCanChangeArgs.testCanChangeArgs(new String[]{"1","2"},"3","4");
	}
	
	public static void main(String[] args) {
		TestArrayAndCanChangeArgs.main(new String[]{"1","2"},"3","4");
	}
	
}
