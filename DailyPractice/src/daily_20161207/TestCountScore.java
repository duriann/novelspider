package daily_20161207;
import java.util.*;
public class TestCountScore {
	public static void main(String[] args) {
		int[] score=new int[5];
		int zonghe=0;
		int avg;
		System.out.println("请输入成绩");
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		for(int i=0;i<score.length;i++) {
			score[i]=input.nextInt();
			zonghe+=score[i];
			}
		avg=zonghe/score.length;
		System.out.println("平均成绩"+avg);
	}

}
