package test07;

import java.util.Random;
import static utils.ThinkingJavaUtils.*;
public class Practice18 {
	private static Random random = new Random(47);
	public final int a = random.nextInt(10);
	public static final int b = random.nextInt(10);
	public void say(){
		println("a:"+a+" b:"+b);
	}
	public static void main(String[] args) {
		Practice18 pt2 = new Practice18();
		pt2.say();
		Practice18 pt = new Practice18();
		pt.say();
		//pt.b++;
		Practice18 pt3 = new Practice18();
		pt3.say();
	}

}
