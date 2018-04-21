import java.util.Random;
/**
 * 测试Class.forName和静态属性与final关系的实例化
 * @author pineapple
 *
 */
public class ClassInitTest {
	public static Random rand = new Random(47);
	public static void main(String[] args) throws Exception {
		//Class<?> init1 = Init1.class;
		System.out.println(Init1.staticFinal1);
		//System.out.println(Init1.staticFinal2);
		//System.out.println(Init2.staticNoFinal);
		//Class<?> init3 = Class.forName("Init3");
	}
}
/**
 * 直接类名调用静态final已结给定数值的静态属性时  不会加载整个类 
 * @author pineapple
 *
 */
class Init1 {
	static final int staticFinal1 = 47;
	static final int staticFinal2 = ClassInitTest.rand.nextInt(1000);
	static {
		System.out.println("initializing init1");
	}
}
/**
 * 直接类名调用非final的静态属性时 会先加载静态代码块
 * @author pineapple
 *
 */
class Init2 {
	static int staticNoFinal = 147;
	
	static {
		System.out.println("initializing init2");
	}
}
/**
 * Class.forName 会直接加载类
 * @author pineapple
 */
class Init3 {
	static int staticNoFinal = 74;

	static {
		System.out.println("initializing init3");
	}
}