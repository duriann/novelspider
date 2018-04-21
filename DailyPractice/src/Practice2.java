/**
 * 题目：判断101-200之间有多少个素数，并输出所有素数。  
 * 判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除，则表明此数不是素数，反之是素数。
 * @author pineapple
 *
 */
public class Practice2 {

	public static void main(String[] args) {
		int count = 0;
		boolean flag = true;
		for(int i = 101;i<200;i++){
			for(int j =2;j<i;j++){
				int k = i%j;
				if(k==0){
					flag = false;
					break;					
				}else{
					flag = true;
				}			
			}
			if(flag==true){
				System.out.println(i+"是素数");
				count++;	
			}
		}
		System.out.println("一共有"+count+"个素数");
		
	}	
}
