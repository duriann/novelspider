package daily_20161024;

public class TestL {

	public static void main(String[] args) {
		/**
		 * a b c 
		 * d e f
		 * g h i
		 */
		int count = 0;
		int[] number = { 1,2,3,4,5,6,7,8,9 };
		for (int a = 0; a < number.length; a++) {
			for (int b = 0; b < number.length; b++) {
				for (int c = 0; c < number.length; c++) {
					for (int d = 0; d < number.length; d++) {
						for (int e = 0; e < number.length; e++) {
							for (int f = 0; f < number.length; f++) {
								for (int g = 0; g < number.length; g++) {
									for (int h = 0; h < number.length; h++) {
										for (int i = 0; i < number.length; i++) {
											int[] temp = { a, b, c, d, e, f, g, h, i};
											if(fun(temp)){
												if(number[a]+number[b]+number[c]==15
												 &&number[g]+number[h]+number[i]==15
												 &&number[d]+number[e]+number[f]==15
												 &&number[a]+number[e]+number[i]==15
												 &&number[g]+number[e]+number[c]==15
												 &&number[a]+number[d]+number[g]==15
												 &&number[c]+number[f]+number[i]==15
												 &&number[b]+number[e]+number[h]==15)
												 {
												System.out.println("找到"+(count+1)+"个");
									
												 System.out.print(number[a] + " " + number[b] + " " + number[c]);
												 System.out.println();
												 System.out.print(number[d] + " " + number[e] + " " + number[f]);
												 System.out.println();
												 System.out.print(number[g] + " " + number[h] + " " + number[i]);
												 System.out.println();
												 System.out.println("------------");
												
												 count ++;
												
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	/**
	 * 判断每层循环各不相等
	 * 
	 * @param temp
	 * @return
	 */
	public static boolean fun(int temp[]) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = i + 1; j < temp.length; j++) {
				if (temp[i] == temp[j])
					return false;
			}
		}
		return true;
	}
}
