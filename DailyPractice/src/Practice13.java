/**
 * 题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
 *  程序分析：在10万以内判断，先将该数加上100后再开方，再将该数加上268后再开方，如果开方后的结
 *果满足如下条件，即是结果。
 * @author pineapple
 * @time 2016年10月9日下午7:22:17
 */
public class Practice13 {

	public static void main(String[] args) {
		/*Double f = Math.sqrt(168);
		System.out.println(f);//5.0
		String s = f.toString();
		s = s.substring(s.lastIndexOf(".")+1);
		System.out.println(s);*/
		for(int i = 0;i<100000;i++){
			Double k = Math.sqrt(i);
			Double k1 = k+100;
			Double k2 = Math.sqrt(k1);
			String sk = k2.toString();
			sk = sk.substring(sk.lastIndexOf(".")+1);
			if(sk.equals("0")){
				k1 = k1+168;
				k2 = Math.sqrt(k1);
				sk = k2.toString();
				sk = sk.substring(sk.lastIndexOf(".")+1);
				if(sk.equals("0")){
					System.out.println(i);
				}
			}			
		}
	}

}
