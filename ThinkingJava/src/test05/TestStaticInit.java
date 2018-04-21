package test05;
import static java.lang.System.out;
public class TestStaticInit {

	public static void main(String[] args) {
		out.print("Create new Cupboard() in main");
		new Cupboard();
		out.print("Create new Cupboard() in main");
		new Cupboard();
		table.f2(1);
		cupboard.f3(1);
	}
	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();
}
class Bowl{
	Bowl(int marker){
		out.println("Bowl:"+marker);
	}
	void f1(int marker){
		out.println("f1:"+marker);
	}
}
class Table{
	static Bowl b1 = new Bowl(1);
	Table(){
		out.println("Table()");
		b2.f1(1);
	}
	void f2(int marker){
		out.println("f2:"+marker);
	}
	static Bowl b2 = new Bowl(2);
}
class Cupboard{
	Bowl b3 = new Bowl(3);
	static Bowl b4 = new Bowl(4);
	Cupboard(){
		out.println("Cupboard");
		b4.f1(2);
	}
	void f3(int marker){
		out.println("f3:"+marker);
	}
	static Bowl b5 = new Bowl(5);
}


