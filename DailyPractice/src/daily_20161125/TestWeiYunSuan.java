package daily_20161125;
/**
 * 
 * @author pineapple
 * @time 2016年11月25日下午4:06:32
 */
public class TestWeiYunSuan {

	public static void main(String[] args) {
		anweiyu();
		
	}
	public static void zuoyiyouyi(){
		// 128 64 32 16 8 4 2 1 左移n相当于乘以2^n 右移刚好相反
				int i = 3 << 1;
				System.out.println(i);
				int k = -3 << 3;
				System.out.println(k);

				int j = 4 >> 1;
				System.out.println(j);
				
				int l = -5 >>3;
				System.out.println(l);
	}
	public static void jinzhizhuanhuan(){
		String binary1 = Integer.toBinaryString(5);
		String binary = Integer.toBinaryString(-5);
		System.out.println(binary1);// int 32位 00000000000000000000000000000101
		System.out.println(binary);// 负数以其正值的补码(反码加1)形式存在11111111111111111111111111111011

	}
	public static void anweiyu(){
		/**
		 * 符号 &
		 * 5->00000000000000000000000000000101
		 * 3->00000000000000000000000000000011
		 * &->00000000000000000000000000000001	
		 * 只有都为1才是1
		 */
		System.out.println(5&3);
				
	}
	public static void anweihuo(){
		/**
		 * 符号 |
		 * 5->00000000000000000000000000000101
		 * 3->00000000000000000000000000000011
		 * |->00000000000000000000000000000111
		 * 只要有1就是1	
		 */
		System.out.println(5|3);
	}
	public static void weiyihuo(){
		/**
		 * 符号 ^
		 * 5->00000000000000000000000000000101
		 * 3->00000000000000000000000000000011
		 * ^->00000000000000000000000000000110
		 */
		System.out.println(5^3);
	}
	public static void weifei(){
		/**
		 * 符号 ~
		 * 一句话: ~n = -n-1
		 */
		System.out.println(~5);
	}
	
}
