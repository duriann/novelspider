package test07;

class Cleanser2 {
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
	
}
public class DetergentDelegation extends Cleanser2{
	private Cleanser2 cleanser2 = new Cleanser2();
	
	@Override
	public void append(String a) {
		cleanser2.append(a);
	}

	@Override
	public void dilute() {
		cleanser2.dilute();
	}

	@Override
	public void apply() {
		cleanser2.apply();
	}

	@Override
	public void scrub() {
		cleanser2.scrub();
	}
	@Override
	public String toString() {
		return cleanser2.toString();
	}

	public static void main(String[] args) {
		DetergentDelegation x = new DetergentDelegation();
		x.dilute();x.apply();x.scrub();
		System.out.println(x);
	}
}







