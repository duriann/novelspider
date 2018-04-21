package test07;

public class Practice05 {
	public static void main(String[] args) {
		C c = new C();
	}
}
class A {
	A(int a){
		System.out.println("A"+a);
	}
}
class B{
	B(int b){
		System.out.println("B"+b);
	}
}
class C extends A{
	private B b ;
	public C() {
		super('a');
		System.out.println("C");
		b = new B('b');
	}
}