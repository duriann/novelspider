package test02;
/**
 * 测试java自动装箱机智
 * @author pineapple
 *
 */
public class TestAutoPackage {
	static boolean b ;
	static char c ;
	static int i ;
	static short s;
	static long l ;
	static float f;
	static double d;
	static byte bt;

	public static void main(String[] args){
		System.out.println(b);
		System.out.println(c);
		System.out.println(i);
		System.out.println(s);
		System.out.println(l);
		System.out.println(f);
		System.out.println(d);
		System.out.println(bt);
		System.out.println("-----------------------------------分割线");
		int it = new Integer(22);
		System.out.println(it);
		Boolean bl = false;
		Character cc = ' ';
		Integer ig = 1;
		Short st = 2;
		Long lg = 3L;
		Float ft = 4F;
		Double db = 5D;
		Byte bte = 6;
		System.out.println(bl);
		System.out.println(cc);
		System.out.println(ig);
		System.out.println(st);
		System.out.println(lg);
		System.out.println(ft);
		System.out.println(db);
		System.out.println(bte);
		
	}
}
