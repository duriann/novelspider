import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String string = in.nextLine();
			char[] chars = string.toCharArray();
			int length = string.length();
			int dp[][] = new int[length + 1][length + 1];

			for (int i = 0; i < length; i++) {
				for (int j = 0; j < length; j++) {
					if (chars[i] == chars[length - j - 1]) {
						dp[i + 1][j + 1] = dp[i][j] + 1;
					}
					{
						dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]) > dp[i][j]
								? Math.max(dp[i][j + 1], dp[i + 1][j]) : dp[i][j];
					}
				}
			}
			System.out.println(length - dp[length][length]);
		}
	}
}