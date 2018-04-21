package daily_20161024;

public class Test {
	public static void magic(int num) {
		int magic[][] = new int[num][num];
		int n = 1;
		int mark[] = new int[2];
		boolean isMultiple=false;
		for (int i = 0; i < magic.length; i++) {
			for (int j = 0; j < magic.length; j++, n++) {
				if (i == 0 &&j == 0) {
					magic[0][magic.length / 2] = n;
					mark[0] = 0; // x 行
					mark[1] = magic.length / 2; // y 列
					continue;
				}
				
				if(isMultiple){
					magic[mark[0]+1][mark[1]]=n;
					mark[0]=mark[0]+1;
					mark[1]=mark[1];
					isMultiple=false;
				}else{
					if (mark[0] - 1 <= -1) { // 行超出
						magic[magic.length - 1][mark[1] + 1] = n;
						mark[0] = magic.length - 1; // x 行
						mark[1] = mark[1] + 1; // y 列
					} else if (mark[1] + 1 >= magic.length) { // 列超出
						magic[mark[0] - 1][0] = n;
						mark[0] = mark[0] - 1; // x 行
						mark[1] = 0; // y 列
					} else {
						magic[mark[0] - 1][mark[1] + 1] = n;
						mark[0] = mark[0] - 1; // x 行
						mark[1] = mark[1] + 1; // y 列
					}
					if(n%magic.length==0){
						isMultiple=true;
					}
				}
			}
		}
		for (int i = 0; i < magic.length; i++) {
			for (int j = 0; j < magic.length; j++) {
				System.out.print(magic[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		magic(4);
	}
}
