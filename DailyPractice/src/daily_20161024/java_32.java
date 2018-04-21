package daily_20161024;

import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author pineapple
 * 	题目：
	编写一个输出n阶幻方的方法magic，将n阶幻方作为该方法的返回值。
	从键盘输入幻方的阶数n（n为大于等于1的奇数），调用magic方法，输出n阶幻方。
	
	提示：幻方是一个行列数相等的方阵，
	它由1至n*n的数据组成，
	要求其每行、每列和对角线上的数据之和相等
	
	一种算法如下：
	（1）第一数放在方阵的第一行的中央；
	（2）下一个数放在本数的右上方。有几个特殊的情况：
	（i）若当前这个数是n的倍数，则下一个数放在本数的下方；
	（ii）若右上方出了方阵的行，则下一个数放在同列的最后一行；
	（iii）若右上方出了方阵的列，则下一个数放在同行的第一列。
	例如：本算法得到的3阶幻方为：
		8  1  6
		3  5  7
		4  9  2
 */

public class java_32 {

	public static void main(String[] args) throws IOException 
	{
		
				System.out.println("输入n为大于等于1的奇数");
				Scanner sc = new Scanner(System.in);
				int num  = sc.nextInt();
				magic(Math.abs(num));
				sc.close();
			
		
	}
	
	public static void magic(int num)
	{
		if(num%2 == 0 && num <= 1){
			System.out.println("输入错误，请n为大于等于1的奇数");
		}else {
			
			int[][] arr = new int[num][num];
			int i = 0;//矩阵的行
	        int j = (num + 1) / 2;  //方阵右上方
	        for (int n = 1; n <= num * num; n++) {  //填入1~n*n数据。
	            if ((n % num) == 1) { 
	                i++;  
	            } else {  
	                i--;  
	                j++;  
	            }  
	            if (i == 0)  i = num; //若右上方出了方阵的行，则下一个数放在同列的最后一行；
	            if (j > num) j = 1;   //若右上方出了方阵的列，则下一个数放在同行的第一列。
	            arr[i-1][j-1] = n;  
	        }  
	               
	        //打印幻方
	        for (int k = 0; k < arr.length; k++) {  
	            for (int l = 0; l < arr[0].length; l++) {  
	                System.out.print(arr[k][l] + " ");  
	            }  
	            System.out.print("\n");  
	        }
		}
	}
}

