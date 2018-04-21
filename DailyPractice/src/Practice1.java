/**
 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子
 * 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问第十个月的兔子对数为多少？  
 * 程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
 * @author pineapple
 *
 */
public class Practice1 {

	public static void main(String[] args) {
		System.out.println(Practice1.count(8));
		
	}
	public static int count(int n){
		if (n==1||n==2) {
			return 1;
		}
		return count(n-1)+count(n-2);
	}
}
