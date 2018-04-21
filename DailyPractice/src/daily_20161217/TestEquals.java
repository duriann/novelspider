package daily_20161217;

public class TestEquals {

	public static void main(String[] args) {
		//1:java中两个对象的比较 是按照内存地址来的 
		String s1 = new String("abc");
		String s2 = new String("abc");
		System.out.println(s1==s2);//返回的是false 因为他们都是"new"出来的内存地址不一样 所以肯定返回false
		//2:equals方法也是默认按照内存地址来比较的，这个方法是Object的 所以所有类都有继承到这个方法
		
		System.out.println(s1.equals(s2));//返回的是false? 不是的先跳过
		System.out.println("----------------------------------------我是分割线");
		//如果我们有一个猫的类，想说如果两只猫的名字和年龄都相等的话 那就是同一只猫 就需要重写那个继承自object的equals方法
		Cat c1 = new Cat("tom", 1);
		Cat c2 = new Cat("tom",1);
		System.out.println(c1==c2);//这边肯定都是返回false的 因为内存地址不同
		System.out.println(c1.equals(c2));
		//现在就相等了，至于为什么String的equals返回true 是因为jdk默认已经重写了 改成了判断数值相等就相等
		//就是这样
	}

}
