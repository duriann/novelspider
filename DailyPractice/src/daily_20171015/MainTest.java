package daily_20171015;

import java.util.HashSet;
import java.util.Set;

public class MainTest{
	public static int[] minArr = {66,666,6666,66666,666666,6666666,66666666,666666666};
	public static int[] maxArr = {88,888,8888,88888,888888,8888888,88888888,888888888};
	public static void main(String[] args) {
		getLuckNum(100,55555);
	}
	public static void getLuckNum(int i ,int k ){
		Set<Integer> set = new HashSet<>();
		int min = 0;
		int max = 0;
		for(int key : minArr){
			if (i<key) {
				set.add(key);
				min = key;
				break;
			}
		}
		
		for(int key : maxArr){
			if (k<key) {
				set.add(key);
				max = key;
				break;
			}
		}
		
		//666 668 686 688 866 868 886 888  8888888
//		for(;min<max;min++){
//			int x = Integer.valueOf(Integer.toBinaryString(min).replace("0", "6").replace("1", "8"));
//			set.add(x);
//		}
		
	}
	
}