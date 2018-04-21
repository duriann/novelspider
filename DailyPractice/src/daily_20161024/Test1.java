package daily_20161024;

import java.util.Vector;


public class Test1 {
	public static void sumDigits(int num){
		String data=String.valueOf(num);
		Vector<Integer> vector=new Vector<Integer>();
		for (int i = 0; i < data.length(); i++) {
			vector.add(Integer.parseInt(data.substring(i,i+1)));
		}
		int sum=0;
		for (int i = 0; i < vector.size(); i++) {
			sum+=vector.get(i);
		}
		System.out.println(sum);
	}
	public static void one(){
		sumDigits(15);
		sumDigits(753);
		sumDigits(4582);
	}
	public static int kn(int x,int y){
		String data=String.valueOf(x);
		String rt="";
		for (int i = 0; i < y; i++) {
			rt+=data;
		}
		return Integer.valueOf(rt);
	}
	public static void two(){
		int s1,s2;
		s1=kn(6,1)+kn(6,2)+kn(6,3)+kn(6,4)+kn(6,5);		
		System.out.println("s1="+s1);
		s2=kn(8,1)+kn(8,3)+kn(8,5)+kn(8,7);
		System.out.println("s2="+s2);
	}
	
	public static int reverse(int data){
		String str=String.valueOf(data);
		StringBuffer buffer=new StringBuffer(str);
		int rt=Integer.valueOf(buffer.reverse().toString());
		return rt;
	}
	public static void isPalindrome(int data){
		if(data==reverse(data)){
			System.out.println("是回文整数");
		}else{
			System.out.println("不是回文整数");
		}
	}
	public static void three(){
		isPalindrome(123);
		isPalindrome(121);
	}
	
	public static void magic(int data){
		int mgc[][]=new int[data][data];
		int n=1;
		for (int i = 0; i < mgc.length+1; i++) {
			for (int j = 0; j < mgc.length+1; j++,n++) {
				if(i==0 && j==0){
					mgc[0][data/2]=n;
				}
				
			}
		}
	}
	public static void four(){
		
	}
	public static void main(String[] args) {
		two();
	}

}
