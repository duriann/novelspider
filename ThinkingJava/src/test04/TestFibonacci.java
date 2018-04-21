package test04;

public class TestFibonacci {

	public static void main(String[] args) {
		//init(5);
		for(int j = 1;j<=5;j++){
			System.out.println(getFibo(j));
		}
	}
	public static void init(int i){
		int k = 1,z=1,v=0;
		System.out.println(1+"\n"+1);
		for(int w = 0;w<i-2;w++){		
			v=k+z;
			k=z;
			z=v;
			System.out.println(v);
			
		}
	}
	public static int getFibo(int i) {
		  if (i == 1 || i == 2)
		  return 1;
		  else
		  return getFibo(i - 1) + getFibo(i - 2);
	}
}
