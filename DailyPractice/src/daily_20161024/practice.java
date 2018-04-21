package daily_20161024;

public class practice {
	public static int[][] magicOdd(int n) {
		int[][] square = new int[n + 1][n + 1];
		int i = 0;
		int j = (n + 1) / 2;
		for (int key = 1; key <= n * n; key++) {
			if ((key % n) == 1)
				i++;
			else {
				i--;
				j++;
			}
			if (i == 0)
				i = n;
			if (j > n)
				j = 1;
			square[i][j] = key;
		}
		int[][] matrix = new int[n][n];
		for (int k = 0; k < matrix.length; k++) {
			for (int l = 0; l < matrix[0].length; l++) {
				matrix[k][l] = square[k + 1][l + 1];
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		int[][] magic = practice.magicOdd(4);
		for (int k = 0; k < magic.length; k++) {
			for (int l = 0; l < magic[0].length; l++) {
				System.out.print(magic[k][l] + " ");
			}
			System.out.println();
		}
	}
}