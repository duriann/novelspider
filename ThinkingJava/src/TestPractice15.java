import test07.Practice15;
import static utils.ThinkingJavaUtils.*;
public class TestPractice15 {

	public static void main(String[] args) {
		Practice15 pt = new Practice15();
		//pt.say(); 因为设置成了 protected不可见
		TestExtendsPractice15 pet = new TestExtendsPractice15();
		pet.say();
	}

}
class TestExtendsPractice15 extends Practice15{
	public void say(){
		say(5);
		println("TestExtendsPractice15");
	}
}