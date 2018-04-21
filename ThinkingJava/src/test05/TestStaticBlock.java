package test05;

public class TestStaticBlock {
	static String s1 = "s1";
	static String s2;
	static{
		s2 = "s2";
		print(s1);
		print(s2);
	}
	TestStaticBlock(){
		print(s1);
	}
	static void print(String s){
		System.out.println(s);
	}
	public static void main(String[] args) {
		TestStaticBlock.print("start");
		
	} 
	
}
