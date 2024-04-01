import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] dp = new long[117];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		for(int i = 4; i <= 116; i++) {
			dp[i] = dp[i - 1] + dp[i - 3];
		}
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(dp[N]);
	}
}