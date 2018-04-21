package test07;

public class Practice13 extends T{
	private String name = "practice";
	public String getName(){
		return name;
	}
	private void say(Practice13 practice13){
		System.out.println(practice13.getName());
	}
	@Override
	protected void say(int i){
		
	}
	public static void main(String[] args) {
		Practice13 pt = new Practice13();
		pt.say(pt);
		pt.say(5);
		pt.say('a');
		pt.say("s");
	}
}
class T{
	protected void say(int i){
		System.out.println(i);
	}

	protected void say(String s){
		System.out.println(s);
	}
	protected void say(char c){
		System.out.println(c);
	}
}