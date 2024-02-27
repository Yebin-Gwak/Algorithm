import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		
		int[] dp = new int[N + 3];
		
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i = 4; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;

			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			}
			
		}
		
		System.out.println(dp[N]);
		
	}

}