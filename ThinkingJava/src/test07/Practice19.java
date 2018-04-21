package test07;
import static utils.ThinkingJavaUtils.*;
public class Practice19 {
	private final Man man;
	public Practice19(String name) {
		man = new Man(name);
	}
	public static void main(String[] args) {
		Practice19 pc = new Practice19("菠萝");		
		println(pc.man.getName());
		pc.man.setName("苹果");
		println(pc.man.getName());
		/*Man realMan = new Man("荔枝");
		pc.man = realMan;
		final类的引用不能改变
		*/
		
	}
}
class Man{
	private String name;
	public Man(String name){
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
