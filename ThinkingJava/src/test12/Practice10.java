package test12;

public class Practice10 {

	public static void main(String[] args) throws Exception {
		new Practice10().f();

	}
	public void f() throws Exception{
		try{
			g();
		}catch(Exception e){
			//e.printStackTrace();
			throw new Exception(" f() Exception");
		}
	}
	public void g() throws Exception{
		throw new RuntimeException();
	}
}
