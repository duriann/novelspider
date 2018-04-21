package test04;
/**
 * 打印a~z的小写英文字母
 * @author pineapple
 *
 */
public class ListCharacters {

	public static void main(String[] args) {
		method1();
	}
	public static void method1(){
		for(char c =0;c<128;c++){
			//判断是否是小写字符
			if (Character.isLowerCase(c)) {
				System.out.println("value:"+(int)c+" character:"+c);
			}
		}
	}
	public static void method2(){
		for(char c=97;c<123;c++){
				System.out.println(" character:"+c);			
		}
	}
}
