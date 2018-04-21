package daily_20161024;

public class TestDiGui {

	public static void main(String[] args) {
		int n[] = {1,2,3,4,5,6,7,8,9};
		display1(n,0,n.length-1);
	}
	public static void display1(int []n,int start,int end){
		if(start == end){
			System.out.print(n[start]+"");
		}else{
			int mid = (start+end)/2;
			display1(n,start,mid);
			display1(n, mid+1, end);
		}
	}
	public static void display2(int[]n,int start,int end){
		if(start<=end){
			System.out.println(n[start]);
			display2(n, start+1, end);
		}
	}
}
