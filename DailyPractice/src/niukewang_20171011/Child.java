package niukewang_20171011;

import java.util.ArrayList;
import java.util.Iterator;

public class Child extends Person{
	public String grade;
	public static void main(String[] args) {
		/*Person p = new Child();
		p.say();*/
		ArrayList<String> list = new ArrayList<String>();
		list.add(0, "aa");
		list.add(0, "bb");
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()){
			String next = iterator.next();
			System.out.println(next);
		}
	}
	@Override
	public void say() {
		System.out.println("child.."+getClass().getSimpleName());
	}
}
