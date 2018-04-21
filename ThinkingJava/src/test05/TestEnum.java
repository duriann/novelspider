package test05;

public class TestEnum {
	 Money money;
	public TestEnum(Money money) {
		this.money = money;
	}
	
	public  void testSwitch(){
		switch (money) {
		case FEN:
				System.out.println("分");
			break;
		case JIAO:
				System.out.println("角");
				break;
		case YUAN:
				System.out.println("元");
		default:
			break;
		}
	}
	public static void main(String[] args) {
		for (Money money:Money.values()) {
			System.out.println("values:"+money+" ordinal:"+money.ordinal());
		}
		
		TestEnum t1 = new TestEnum(Money.FEN);
		TestEnum t2 = new TestEnum(Money.JIAO);
		TestEnum t3 = new TestEnum(Money.YUAN);
		t1.testSwitch();
		t2.testSwitch(); 
		t3.testSwitch();
	}
	public enum Money{
		FEN,JIAO,YUAN;
		//String s = "2";
		//public void testMoney(){} 枚举也是一种类
	}
}
