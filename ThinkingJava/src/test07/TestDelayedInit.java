package test07;

public class TestDelayedInit {

	private SimpleClass simpleClass;
	public TestDelayedInit(){
		System.out.println("TestDelayedInit..");
		simpleClass = new SimpleClass();
	}
	public static void main(String[] args) {
		TestDelayedInit ti = new TestDelayedInit();
	}

}
class SimpleClass{
	SimpleClass(){
		System.out.println("SimpleClass.");
	}
}