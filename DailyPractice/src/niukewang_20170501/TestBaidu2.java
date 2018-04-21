package niukewang_20170501;

import java.util.Scanner;

public class TestBaidu2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n>50){
			sc.close();
			return;
		}
		int[]arr = new int[n];
		for(int i = 0;i<arr.length;i++){
			arr[i]=sc.nextInt();
		}
		int min=0;
		for(int i = 0;i<arr.length-1;i++){
			if(arr[i]<arr[i+1]){
				min=arr[i];
			}
		}
		System.out.println(min);
		
		sc.close();
	}
}
