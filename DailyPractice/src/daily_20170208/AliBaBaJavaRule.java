package daily_20170208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AliBaBaJavaRule {

	@Test
	public void testForeach() {
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("2");
		for (String temp : a) {
			if ("2".equals(temp)) {
				a.remove(temp);
			}
		}
		System.out.println(a);
	}

	@Test
	public void testAsList() {
		String[] names = new String[] { "a", "b" };
		List<String> lists = Arrays.asList(names);
		// lists.add("c");报错
		names[0] = "aa";
		String first = lists.get(0);
		System.out.println(first);
	}

	@Test
	public void testToArray() {
		List<String> list = new ArrayList<String>(2);
		list.add("guan");
		list.add("bao");
		String[] array = new String[list.size()];
		array = list.toArray(array);
		System.out.println(array);
	}
}
