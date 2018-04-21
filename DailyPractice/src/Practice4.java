import java.util.Scanner;

/**
 * 题目：输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数。 
 * 程序分析：利用while语句,条件为输入的字符不为'\n'. 
 * @author pineapple
 *
 */
public class Practice4 {

	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			String s = sc.nextLine();
			sc.close();
			int countWord=0;
			int countKonge = 0;
			int countElse = 0;
			int countNum = 0;
			
			char[]c = s.toCharArray();
			for(int i = 0;i<c.length;i++){
				if ((97<=c[i]&&c[i]<123)||(65<=c[i]&&c[i]<=90)) {
					countWord++;
				}
				else if ((48<=c[i]&&c[i]<=57)){
					countNum++;
				}
				else if (c[i]==32) {
					countKonge++;
				}
				else{
					countElse++;
				}
			}
			System.out.println(countWord+"个英文字符 "+countNum+"个数字 "+countKonge+"个空格 "+countElse+"个其它字符");
		}
		
}