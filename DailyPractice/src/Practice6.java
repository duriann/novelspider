import java.util.Scanner;

/**
 *题目：求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个的数字。
 *例如2+22+222+2222+22222(此时共有5个数相加)
 *几个数相加有键盘控制。 
 * @author pineapple
 *
 */
public class Practice6 {

	public static void main(String[] args) {
		System.out.println("求s=a+aa+aaa+aaaa+aa...a的值,请输入a的值");
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in).useDelimiter("\\s*");
		int a = scan.nextInt();
		int n = scan.nextInt();
		count(a,n);
		scan.close();
		
	}	
	public static void count(int a,int n){
		int[]arr = new int[n];
		int sum = 0;
		int su = 0;
		for(int i=0 ;i<n;i++){	
			sum = sum*10+a;
			arr[i] = sum;
			System.out.println("第"+i+"个"+"sum: "+sum);
			su = su+sum;
		}
		for(int i = 0;i<arr.length;i++){
			System.out.println(arr[i]+"+");
		}
		System.out.println(sum);
		System.out.println(su);
	}
	
}
class A{
	public static void main(String[] args) {
		  /*System.out.print("求s=a+aa+aaa+aaaa+...的值，请输入a的值：");   
		  Scanner scan = new Scanner(System.in).useDelimiter("\\s*");
		  //以空格作为分隔符   
		  int a = scan.nextInt();     
		  int n = scan.nextInt();
		  scan.close();//关闭扫描器 
*/		  System.out.println(expressed(2,3));
	}

	private static long add(int a, int n) {
		long sum = 0;   
		long subSUM = 0;  
		for(int i=1;i<n+1;i++){   
			subSUM = subSUM*10+a;   
			sum = sum+subSUM;    
			}    
		return sum;
	}

	private static String expressed(int a, int n) {
		StringBuffer sb = new StringBuffer();
		StringBuffer subSB = new StringBuffer();
		for(int i=1;i<n+1;i++){
			subSB = subSB.append(a);
			System.out.println("subSB: "+subSB);
			sb = sb.append(subSB);
			System.out.println("sb: "+sb);
			if(i<n){
				sb = sb.append("+");
			}		
		}
		sb.append("=");
		return sb.toString();
	}
}