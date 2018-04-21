package test05;

import java.lang.reflect.Constructor;

public class TestConstructor {
	
	String name;
	String name2="pineapple2";
	public TestConstructor() {
		System.out.println(name2);
		System.out.println("name:"+name);
		name = new String("pineapple");
		System.out.println("name:"+name);
	}
	
	public TestConstructor(String args){
		System.out.println("args:"+args);
	}
	public static void main(String[] args) {
		//TestConstructor test = new TestConstructor();
		//TestConstructor test2 = new TestConstructor("null");
		Class clazz = NullConstructor.class;
		Constructor[] constructors = clazz.getConstructors();
		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			System.out.println(constructor.getName());
		}
	}

}
class NullConstructor{
	
}