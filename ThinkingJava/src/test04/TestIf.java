package test04;

import java.util.Random;

import org.junit.Test;

public class TestIf {

	@Test
	public void testRandom(){
		Random random = new Random(47);
		int[] i = new int[25];
		for(int j = 0;j<i.length;j++){
			i[j] = random.nextInt(10);
		}
		for (int j : i) {
			System.out.print(j);
		}
		System.out.println();
		int count = 0;
		for (int j = 0; j < i.length-1; j++) {
			if (i[j]>i[j+1]) {
				System.out.println(i[j]+">"+i[j+1]);
				count++;
			}else if(i[j]<i[j+1]){
				System.out.println(i[j]+"<"+i[j+1]);
				count++;
			}else{
				System.out.println(i[j]+"="+i[j+1]);
				count++;
			}
		}
		System.out.println(count);
		
	}
	public static void main(String[] args) {
		while(true){
			Random random = new Random(47);
			int j = 0 ;
			for(int i = 0;i<25;i++){
				int k = random.nextInt(10);			
				if (k>j) {
					System.out.println(k+">"+j);
				}
				if(k==j){
					System.out.println(k+"="+j);
				}
				if(k<j){
					System.out.println(k+"<"+j);
				}
				j = k;
			}
		}
	}
}
