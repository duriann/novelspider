import java.util.ArrayList;
import java.util.Iterator;

/**
 * 题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。
 * 例如6=1＋2＋3.编程找出1000以内的所有完数。 
 * @author pineapple:虽然可以算出来 但是效率太低 待优化
 *
 */
public class Practice5 {

	public static void main(String[] args) {
		//系统开始运行时间
		long startTime = System.currentTimeMillis();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int sum = 0 ; 
		for(int k = 2 ;k<=100000;k++){
			for(int j = 1;j<k/2+1;j++){
				if(k%j==0&&j!=k){
					list.add(j);
				}

			}
			Iterator<Integer> iterator = list.iterator();
			Integer num = 0;
			while(iterator.hasNext()){
				num = iterator.next();
				sum = sum+num;
			}
			if(k==sum){
				System.out.println(k+"是完数");
			}

			sum = 0;
			list =new ArrayList<Integer>();
			
		}
		long endTime = System.currentTimeMillis();
		System.out.println("程序运行时间："+(endTime-startTime)+"ms");
		
	}	
}