package test07;

class Cleanser {
	private String s = "Cleanser";
	public void append(String a ){
		s = s+a;
	}
	public void dilute(){
		append(" dilute()");//dilute 稀释 冲淡的
	}
	public void apply(){
		append(" apply()");
	}
	public void scrub(){
		append(" scrub()");//scrub 刷洗
	}
	public String toString(){
		return s;
	}
	public static void main(String[] args) {
		Cleanser x = new Cleanser();
		x.dilute();x.apply();x.scrub();
		System.out.println(x);
	}
}
public class Detergent extends Cleanser{
	//change a method
	public void scrub(){
		append("Detergent.scrub()");
		super.scrub();
	}
	//add method to the interface
	public void foam(){
		append(" foam()");
	}
	public static void main(String[] args) {
		Detergent x = new Detergent();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		System.out.println(x);
		System.out.println("Testing base class.");
		Cleanser.main(args);
	}
}
class DetergentSon extends Detergent{
	//change a method 
	public void scrub(){
		super.scrub();
		System.out.println("DetergentSon's scrub");
	}
	public void sterilize(){
		System.out.println("sterilize..");
	}
	public static void main(String[] args) {
		DetergentSon ds = new DetergentSon();
		ds.scrub();
		ds.sterilize();
		System.out.println(ds);
		
	}
}







