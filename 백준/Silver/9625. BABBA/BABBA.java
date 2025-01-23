import java.util.*;

public class Main {
	public static void main(String[] args){
		int N = new Scanner(System.in).nextInt();

		int[][] dp = new int[N + 1][2];
		dp[0][0] = 1;
		dp[1][1] = 1;
		for(int i = 2; i <= N; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}
		System.out.println(dp[N][0] + " " + dp[N][1]);
	}
}