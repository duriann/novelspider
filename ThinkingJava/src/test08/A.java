package test08;

public class A {
	void draw(){System.out.println("A.draw()");};
	public A() {
		System.out.println("A before draw()");
		draw();
		System.out.println("A after draw()");		
	}
	public static void main(String[] args) {
		new B(5);
	}
}
class B extends A{
	private int radius = 1;
	public B(int r) {
		radius = r;
		System.out.println("B.radius:"+radius);
	}
	@Override
	void draw() {
		System.out.println("B.draw(),radius:"+radius);
	}
}