package test03;
/**
 * 随机丢硬币
 */
import java.util.Random;

public class ThrowCoin {

	public static void main(String[] args) {
		Random random = new Random(47);
		int i ;
		for(int k = 0;k<10;k++){
			i = random.nextInt(10);
			if (i%2==0) {
				System.out.println("丢了正面");
			}else {
				System.out.println("丢了反面");
			}
		}
		
	}

}
