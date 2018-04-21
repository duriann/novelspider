package test05;
import static java.lang.System.out;
public class TestInit {

	public static void main(String[] args) {
		House house = new House();
		house.f();
		SmallHouse smallHouse = new SmallHouse(1);
	}

}
class House{
	Window w1 = new Window(1);
	House(){
		out.println("House");
		w3 = new Window(33);
	}
	Window w2 = new Window(2);
	void f(){
		out.println("f()");
	}
	Window w3 = new Window(3);
}
class Window{
	Window(int marker){
		out.println("Window:"+marker);
	}
}
class SmallHouse extends House{
	static int i = 5;
	SmallHouse(int i){
		System.out.println(i);
	}
}