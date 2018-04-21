/**
 * 题目：打印出所有的"水仙花数"，所谓"水仙花数"是指一个三位数
 * 其各位数字立方和等于该数本身。例如：153是一个"水仙花数"
 * 因为153=1的三次方＋5的三次方＋3的三次方。 
 * @author pineapple
 *
 */
public class Practice3 {

	public static void main(String[] args) {
		for(int i = 100;i<1000;i++){
			//个位
			int g = i%10;
			int s = (i%100-g)/10;
			int b = (i%1000-i%100)/100;
			//System.out.println(i+" 百位: "+b+" 十位: "+s+" 个位: "+g);
			int sum = (g*g*g)+(s*s*s)+(b*b*b);
			if (sum==i) {
				System.out.println(i+"是水仙花数");
			}
		}
		
	}
}