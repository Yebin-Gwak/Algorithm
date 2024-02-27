import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N == 1) {
			System.out.println(1);
			return;
		}
		int[][] dp = new int[N + 1][N + 1];
		
		dp[1][0] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		
		for(int i = 3; i <= N; i++) {
			dp[i][0] = dp[i - 1][0] % 10007 + dp[i - 1][1] % 10007;
			dp[i][1] = dp[i - 2][0] % 10007 + dp[i - 2][1] % 10007;
		}
		
		System.out.println((dp[N][0] + dp[N][1]) % 10007);
		

	}

}