package test03;
/**
 * Test object isEqual
 * @author pineapple
 *
 */
public class Dog {
	String name;
	String says;
	public static void main(String[] args) {
		Dog spot = new Dog();
		spot.name = "spot";
		spot.says = "Ruff!";
		Dog scruffy = new Dog();
		scruffy.name = "scruffy";
		scruffy.says = "Wurf!";
		System.out.println(spot.name+":"+spot.says);
		System.out.println(scruffy.name+":"+scruffy.says);
		Dog newdog = new Dog();
		newdog = spot;
		System.out.println(newdog == spot);
		System.out.println(newdog.equals(spot));
	}

}
