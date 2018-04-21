package test07;
import static utils.ThinkingJavaUtils.*;
public class Amphibian {
	//Amphibian 两栖动物
	public void say(Amphibian am){
		println(am.getClass().getSimpleName());
	}
	public static void main(String[] args) {
		
	}
	
	
}
class Frog extends Amphibian{
	
	public static void main(String[] args) {
		Frog frog = new Frog();
		frog.say(frog);
		Amphibian aFrog = new Frog();
		aFrog.say(aFrog);
		/*Frog froga = (Frog) new Amphibian();类型转换错误.
		froga.say(froga);*/
	}
}