
public class TestGouZaoQi {
	public static void main(String[] args) {
		/*D d = new D(5);
		
		System.out.println(d.k);*/
		//int a = 5||6;
		
	}
}
class D{
	int k = 0;
	public D(){
		System.out.println("系统默认调用的");
	}
	public D(int i){
		this.k = i;
	}
	public String say(String i){
		i = i+1;
		return i;
	}
}
