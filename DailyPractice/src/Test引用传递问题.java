
public class Test引用传递问题 {
	 int x ;
	public static void main(String[] args){
		
		Integer var1 = new Integer(1);
		Integer var2 = var1;
		Integer var3 = doSomething(var2);
		System.out.println(var1.intValue());
		System.out.println(var3.intValue());
		System.out.println(var2.intValue());
		System.out.println(var1==var2);
		}
		public static Integer doSomething(Integer integer){
			 integer=new Integer(2);
			 return integer;

		}
}