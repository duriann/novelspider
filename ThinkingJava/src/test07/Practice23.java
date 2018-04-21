package test07;
import static utils.ThinkingJavaUtils.*;

class Insert{
	private int i = 9;
	protected int j;
	Insert(){
		println("i = "+i+", j = "+j);
		j = 39;
	}
	private static int x1 = printInit("static insert.x1 init");
	static int printInit(String s){
		println(s);
		return 47;
	}
}
class Beetle extends Insert{
	private int k = printInit("beetle.k init");
	public Beetle(){
		println("k = "+k);
		println("j = "+j);//继承而来的
	}
	private static int x2 = printInit("static beetle.x2 init");
	
	public static void main(String[] args) {
		println("beetle constructor");
		Beetle.x2 = 5;
		//Beetle beetle = new Beetle();
		System.out.println("我是分割线--------------------");
		//Beetle beetle2 = new Beetle();
	}
}









public class Practice23 {
	public static void main(String[] args) {
		
	}
}




