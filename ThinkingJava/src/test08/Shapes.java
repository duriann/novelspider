package test08;
import static utils.ThinkingJavaUtils.*;
import java.util.Random;
public class Shapes {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	public static void main(String[] args) {
		Shape[]s = new Shape[9];
		for (int i = 0; i < s.length; i++) {
			s[i] = gen.next();
		}
		for (Shape shape : s) {
			shape.draw();
			shape.say();
		}
	}
}
class Shape{
	public void draw(){};
	public void erase(){};
	public void say(){System.out.println("Shape");}
}
class Circle extends Shape{
	@Override
	public void draw(){ println("Circle.draw()"); };
	@Override
	public void erase(){ println("Circle.erase()"); };
	@Override
	public void say(){println("Circle");}
}
class Square extends Shape{
	public void draw(){ println("Square.draw()"); };
	public void erase(){ println("Square.erase()"); };
}
class Triangle extends Shape{
	public void draw(){ println("Triangle.draw()"); };
	public void erase(){ println("Triangle.erase()"); };
}
class RandomShapeGenerator{
	private Random random = new Random(47);
	public Shape next(){
		switch(random.nextInt(3)){
			default:
			case 0:return new Circle();
			case 1:return new Square();
			case 2:return new Triangle();
		}
	}
}