package test08;
import static utils.ThinkingJavaUtils.*;
public class Practice01 {
	public static void main(String[] args) {
		/*Cycle cycle = new Cycle();
		cycle.ride(new Unicycle());
		cycle.ride(new Bicycle());
		cycle.ride(new Tricycle());
		Cycle c1 = new Unicycle();
		c1.ride(c1);*/
		Cycle cycle = new Unicycle();
		cycle.ride(cycle);
	}
}
class Cycle{
	 int wheels = 0;
	protected void ride(Cycle c){
		println(wheels(c));
	}
	protected int wheels(Cycle c){
		return c.wheels;
	}


}
class Unicycle extends Cycle{
	int wheels = 1;
	/*protected void ride(Cycle c) {
		println("Unicycle:"+c.getClass().getSimpleName());
	}*/
}
class Bicycle extends Cycle{
	protected int wheels = 2;
	@Override
	protected void ride(Cycle c) {
		println("Bicycle:"+c.getClass().getSimpleName());
	}
}
class Tricycle extends Cycle{
	protected int wheels = 3;
	@Override
	protected void ride(Cycle c) {
		println("Tricycle:"+c.getClass().getSimpleName());
	}
}