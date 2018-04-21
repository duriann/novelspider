package daily_20171205;

import java.util.HashSet;

public class TestHashSet {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>(0);
		set.add("a");
		
		System.out.println(set.size());
		set.add("aa");
		
		System.out.println(set.size());
	}
}
