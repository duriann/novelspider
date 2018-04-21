
public class 滚动数组 {

	public static void main(String[] args) {
		fib2();
		//fib(10);
		//qiu3deyushu();
	}
	//普通数组方法打印前K个斐波那契数列
	public static void fib(int k){
		int d[]=new int[k];  
		  
		d[0]=1;d[1]=1;  
		System.out.println(d[0]);
		System.out.println(d[1]);
		for(int i=2;i<k;i++)  
		{  
		    d[i]=d[i-1]+d[i-2];
		    System.out.println(d[i]);
		}  
	}
	public static void qiu3deyushu(){
		for(int i = 1;i<100;i++){
			System.out.println(i%3);
		}
	}
	//滚动数组方法打印
	public static void fib2(){
		int d[]=new int[3];  
		  
		d[0]=1;d[1]=1;  
		//System.out.println(d[0]);
		//System.out.println(d[1]); 
		
		for(int i=2;i<20;i++)  
		{  
			for (int k =0;k<d.length;k++) {
				if(k==d.length-3){
					System.out.print("[ ");
				}
				System.out.print(d[k]);
				if(k!=d.length-1){
					System.out.print(",");
				}else{
					System.out.print(" ]");
				}
				
			}
		   d[i%3]=d[(i-1)%3]+d[(i-2)%3];
		   //d[2] = d[1%3] + d[0%3] = 2
		   System.out.println(d[i%3]);
		}  
		  
		
	}
}
