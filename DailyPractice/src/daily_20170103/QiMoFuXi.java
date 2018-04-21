package daily_20170103;

public class QiMoFuXi {
	public static void print(Object object){
		System.out.println(object);
	}
	public static void main(String[] args) {
		print(jieceng(4));
	}
	
	public static int jieceng(int i){
		if(i==1){
			return i;
		}
		return i*jieceng(--i);
	}
 	
}
