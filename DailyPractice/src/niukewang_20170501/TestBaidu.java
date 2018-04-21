package niukewang_20170501;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class TestBaidu {

	@Test
	public void testSet(){
		Set<Integer> set = new TreeSet<>();
		set.add(1);
		set.add(1);
		set.add(1);
		set.add(3);
		set.add(3);
		set.add(5);
		Object[] array = set.toArray();
		for (Object a : array) {
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Set<Integer> set = new TreeSet<>();
		if(n<3){
			System.out.println(-1);
			sc.close();
			return;
		}
		for(int i= 0;i<n;i++){
			set.add(sc.nextInt());
		}
		Object[] array = set.toArray();
		if(array.length<3){
			System.out.println(-1);
			sc.close();
			return;
		}
		System.out.println(array[2]);
	
		sc.close();
	}

}
