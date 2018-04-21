package test02;

/**
 * 无聊测试主函数调用
 * @author pineapple
 *
 */
public class TestMainExtends {

	public static void main(String[] args) {
		String[]b = {"1","2"};
		System.out.println("我是A");
		B.main(b);
	}
	public void testMain(){
		String[]b = {"1","2"};
		B.main(b);
	}

}
class B extends TestMainExtends{
	public static void main(String[] args) {
		
		System.out.println(args[0]);
	}
}