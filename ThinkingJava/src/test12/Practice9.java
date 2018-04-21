package test12;

public class Practice9 {
	public static void main(String[] args) {
		try {
			new Practice9().f();
		} catch (Exception e) {
			System.out.println("异常呢?");
			e.printStackTrace();
		}
	}
	public void f() throws MyException1, MyException2,MyException3{
		throw new MyException1("1");
		//throw new MyException2("");
		//throw new MyException3("");
		
	}
}
class MyException1 extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return super.toString();
	}
	private String msg ;
	public MyException1(String msg) {
		this.msg = msg;
	}
}
class MyException2 extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg ;
	public MyException2(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
class MyException3 extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg ;
	public MyException3(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "MyException3 [msg=" + msg + "]";
	}
}
